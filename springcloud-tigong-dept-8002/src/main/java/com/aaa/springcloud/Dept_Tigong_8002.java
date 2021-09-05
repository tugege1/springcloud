package com.aaa.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//添加mapperscan注解，扫描mapper层，不然报找不到bean
@MapperScan("com.aaa.springcloud.mapper")
//添加客户端核心注解，自动注册进服务器
@EnableEurekaClient
//添加这个注解是为了得到微服务信息
@EnableDiscoveryClient
public class Dept_Tigong_8002 {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Tigong_8002.class, args);
    }
}
