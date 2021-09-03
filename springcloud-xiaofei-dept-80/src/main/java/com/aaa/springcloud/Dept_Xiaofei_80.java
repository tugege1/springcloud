package com.aaa.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//添加Eureka注解  从注册中心获取服务
@EnableEurekaClient
public class Dept_Xiaofei_80 {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Xiaofei_80.class, args);
    }
}
