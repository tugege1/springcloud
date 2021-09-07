package com.aaa.springcloud.service;

import com.aaa.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> selDepts();

    public Dept selDeptById(Long id);

    public boolean addDept(Dept dept);

}
