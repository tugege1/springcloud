package com.aaa.springcloud.controller;

import com.aaa.springcloud.entity.Dept;
import com.aaa.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    //注入这个类，使用它提供的方法
    @Autowired
    private DiscoveryClient client;


    //根据id查询部门   使用Hystrix熔断，每个方法都应该有一个备份，这里只测试一个方法。
    @GetMapping("/{id}")
    //核心注解  指定备选方案(注意：回退方法参数和返回值要和原方法一致)
    @HystrixCommand(fallbackMethod = "deptHystrix")
    public Dept selDeptById(@PathVariable Long id) {
        Dept dept = deptService.selDeptById(id);
        if (dept == null) {
            //抛出异常，如果没有接收，也会报错
            throw new RuntimeException("id不存在或输入错误!");
        }
        return dept;
    }

    //这个是备选方案，Hystrix配置后，出现问题可以使用这个方法
    public Dept deptHystrix(@PathVariable Long id) {
        return new Dept().setDeptno(id).setDname("id不存在或输入错误!").setDb_source("数据库信息不存在");
    }


}
