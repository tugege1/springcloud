package com.aaa.springcloud.service;

import com.aaa.springcloud.entity.Dept;
import com.google.gson.Gson;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DeptClentServiceFallBack implements FallbackFactory<DeptClientService> {

    //实现FallbackFactory接口，重新方法
    @Override
    public DeptClientService create(Throwable throwable) {

        //返回重写方法的接口   代表降级
        return new DeptClientService() {
            @Override
            public String selDepts() {
                return null;
            }

            @Override
            public String selDeptById(String id) {
                Dept dept = new Dept()
                        .setDeptno(Long.parseLong(id))
                        .setDname("id"+id+"不存在或输入错误!")
                        .setDb_source("数据库信息不存在");
                return new Gson().toJson(dept);
            }

            @Override
            public String addDept(Dept dept) {
                return null;
            }

            @Override
            public Object getDis() {
                return null;
            }
        };
    }
}
