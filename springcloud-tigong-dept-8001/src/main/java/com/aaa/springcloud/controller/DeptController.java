package com.aaa.springcloud.controller;

import com.aaa.springcloud.entity.Dept;
import com.aaa.springcloud.service.DeptService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    //注入这个类，使用它提供的方法
    @Autowired
    private DiscoveryClient client;

    //查询所有部门
    @GetMapping
    public String selDepts() {
        List<Dept> list = deptService.selDepts();
        return new Gson().toJson(list);
    }

    //根据id查询部门
    @GetMapping("/{id}")
    public String selDeptById(@PathVariable String id) {
        Dept dept = deptService.selDeptById(id);
        return new Gson().toJson(dept);
    }

    //新增部门
    @PostMapping("/addDept")
    public String addDept(@RequestBody Dept dept) {
        System.out.println(dept);
        boolean insert = deptService.addDept(dept);
        return insert == true ? "成功" : "失败";
    }

    //新增一个Api,用来获取微服务信息
    @GetMapping("/other/discovery")
    public Object discovery() {
        //获得微服务列表
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        //再通过一个具体的微服务id，获取到关于它的所有信息
        List<ServiceInstance> instance = client.getInstances("springcloud-tigong-ip");
        //最后foreach遍历出信息
        for (ServiceInstance tigong : instance) {
            System.out.println(
                    tigong.getHost() + "\t" + // 主机名称
                            tigong.getPort() + "\t" + // 端口号
                            tigong.getUri() + "\t" + // uri
                            tigong.getServiceId() // 服务id
            );
        }
        //object类型，不是String类型
        return this.client;
    }


}
