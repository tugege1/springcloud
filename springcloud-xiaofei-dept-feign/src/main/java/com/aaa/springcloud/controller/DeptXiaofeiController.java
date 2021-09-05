package com.aaa.springcloud.controller;

import com.aaa.springcloud.entity.Dept;
import com.aaa.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptXiaofeiController {

    //使用Feign，社区版。  更加符合面向接口编程，就像调用普通service一样，注入
    @Autowired
    private DeptClientService deptClient;

    //业务逻辑层返回的数据已经处理。 这边直接返回即可
    @GetMapping
    public String getList() {
        //使用Ribbon+RestTemplate，路径写在这里
        //List<Dept> deptList = restTemplate.getForObject(OLD_URL_PREFIX + "/api/v1/dept", List.class);

        //而使用Feign，就像之前调用service一样简单！
        return deptClient.selDepts();
    }

    @GetMapping("/{id}")
    public String getDeptById(@PathVariable String id) {
        //使用Feign，就像之前调用service一样简单,路径在配置service里配置，并且也不需要拼接接口路径，以及参数问题
        return deptClient.selDeptById(id);
    }

    @GetMapping("/add")
    public String addDept(Dept dept) {
        return deptClient.addDept(dept);
    }

    @GetMapping("/getdis")
    public Object getDis() {
        return deptClient.getDis();
    }

}
