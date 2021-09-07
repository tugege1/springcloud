package com.aaa.springcloud.service;

import com.aaa.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//使用这个注解，使用value指定服务名。和ribbon原理一样。从注册中心拿这个服务，代替路径
//添加Hystrix降级:FallBackFactory指定降级配置类
@FeignClient(value = "springcloud-tigong-ip",fallbackFactory = DeptClentServiceFallBack.class)
//Feign的service配置。 写在这边，可以降低耦合。 并且增加代码可读性
public interface DeptClientService {

    //社区版，更符合面向接口编程。  使用直接调用这个接口就可以，类型dao,controller
    //这里的路径并不是要我们访问。而是类似Ribbon+RestTemplate，系统去访问的，真正逻辑接口的路径

    @GetMapping("/api/v1/dept")
    public String selDepts();

    @GetMapping("/api/v1/dept/{id}")
    public String selDeptById(@PathVariable("id") String id);

    @PostMapping("/api/v1/dept/addDept")
    public String addDept(Dept dept);

    @GetMapping("/api/v1/dept/other/discovery")
    public Object getDis();
}
