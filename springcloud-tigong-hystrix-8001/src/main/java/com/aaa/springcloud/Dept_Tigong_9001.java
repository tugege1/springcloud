package com.aaa.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//添加mapperscan注解，扫描mapper层，不然报找不到bean
@MapperScan("com.aaa.springcloud.mapper")
//添加客户端核心注解，自动注册进服务器
@EnableEurekaClient
//添加这个注解是为了得到微服务信息
@EnableDiscoveryClient
//添加Hystrix核心注解
@EnableHystrix
public class Dept_Tigong_9001 {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Tigong_9001.class, args);
    }


    //给需要监控的模块的启动类添加一个servlet
    // 往hystrix-dashborad里面注册
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        //访问该页面就是监控页面
        registrationBean.addUrlMappings("/jiankong");
        return registrationBean;
    }

}
