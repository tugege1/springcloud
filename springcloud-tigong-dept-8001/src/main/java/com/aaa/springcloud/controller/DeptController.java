package com.aaa.springcloud.controller;

import com.aaa.springcloud.entity.Dept;
import com.aaa.springcloud.service.DeptService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

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

}
