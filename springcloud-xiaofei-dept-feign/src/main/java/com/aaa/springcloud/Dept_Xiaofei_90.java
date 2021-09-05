package com.aaa.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//添加Eureka注解  从注册中心获取服务
@EnableEurekaClient
//添加@EnableFeignClients注解，指定要扫描的包以及配置接口DeptClientService
@EnableFeignClients(basePackages = {"com.aaa.springcloud"})
public class Dept_Xiaofei_90 {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Xiaofei_90.class, args);
    }
}
