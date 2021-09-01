package com.aaa.springcloud.service.impl;

import com.aaa.springcloud.entity.Dept;
import com.aaa.springcloud.mapper.DeptMapper;
import com.aaa.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> selDepts() {
        return deptMapper.selDepts();
    }

    @Override
    public Dept selDeptById(String id) {
        return deptMapper.selDeptById(id);
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

}
