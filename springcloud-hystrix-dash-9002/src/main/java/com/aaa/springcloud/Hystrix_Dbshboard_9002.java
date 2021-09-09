package com.aaa.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//添加Hystrix监控依赖  多半都是Enable开头   给需要监控的模块的启动类添加一个servlet
@EnableHystrixDashboard
public class Hystrix_Dbshboard_9002 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix_Dbshboard_9002.class, args);
    }
}
