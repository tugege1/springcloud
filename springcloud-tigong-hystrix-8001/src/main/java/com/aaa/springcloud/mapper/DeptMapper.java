package com.aaa.springcloud.mapper;

import com.aaa.springcloud.entity.Dept;

import java.util.List;

public interface DeptMapper {

    public List<Dept> selDepts();

    public Dept selDeptById(Long id);

    public boolean addDept(Dept dept);
}
