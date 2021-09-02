package com.aaa.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//最重要的就是这个注解:服务端的启动类，可以允许别人注册进来
@EnableEurekaServer
public class Eureka_Server_7003 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_Server_7003.class, args);
    }
}
