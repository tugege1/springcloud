package com.aaa.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    /*首先1:实现序列化
       2:添加属性
       3:添加注解(包含链式写法)*/

    private Long deptno;
    private String dname;
    private String db_source;

}
