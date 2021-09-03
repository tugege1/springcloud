package com.aaa.springcloud.controller;

import com.aaa.springcloud.entity.Dept;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptXiaofeiController {

    //服务消费者(接口)就是调用服务提供者，说白了就是调用接口
    //使用Spring提供的RestTemplate  供我们直接调用，注册到Spring中

    //要调用的接口路径。应该是一个常量，通过地址来访问,达到了解耦
    //private static final String OLD_URL_PREFIX = "http://localhost:8001/api/v1/dept";

    //更改  使用负载均衡后应访问服务的id,应该是一个变量(三个服务，选择一个，要名字一致)，通过服务名访问（配置的服务客户端id名）
    //Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
    //但是注意: 这里的服务名只是代表localhost:8001，但是后面的路径Api等需要在下面拼接，不然访问不到(注册中心拿到怎么知道你去那个接口？)
    private static final String OLD_URL_PREFIX = "http://springcloud-tigong-ip";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getList() {
        //restTemplate的方法根据接口请求方式,get、post等
        //参数为(url路径， 实体(？后缀参数值),  响应的类型)
        List<Dept> deptList = restTemplate.getForObject(OLD_URL_PREFIX + "/api/v1/dept", List.class);
        return new Gson().toJson(deptList);
    }

    @GetMapping("/{id}")
    public String getDeptById(@PathVariable String id) {
        Dept dept = restTemplate.getForObject(OLD_URL_PREFIX + "/api/v1/dept" + "/" + id, Dept.class);
        return new Gson().toJson(dept);
    }

    @GetMapping("/add")
    public String addDept(Dept dept) {
        //使用PathVariable路径/参数值时可以直接拼接，使用RequestParam？参数拼接不能直接在路径拼接
        //这边带数据跳转过去后，另一边接口的参数需要夹@RequestBody，否则无法接收数据,或者404
        System.out.println(dept);
        return restTemplate.postForObject(OLD_URL_PREFIX + "/api/v1/dept" + "/addDept", dept, String.class);
    }

}
