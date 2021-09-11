package com.aaa.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//zuul注解    添加后，可以使用9527/服务名/路径访问，会暴露微服务名字
@EnableZuulProxy
public class Dept_Zuul_9527 {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Zuul_9527.class, args);
    }
}
