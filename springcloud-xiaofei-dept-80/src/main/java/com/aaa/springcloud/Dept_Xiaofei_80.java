package com.aaa.springcloud;

import com.aaa.springcloud.config.RuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
//添加Eureka注解  从注册中心获取服务
@EnableEurekaClient
//在微服务启动的时候就能加载自定义的Ribbon类(自定义的规则会覆盖原有默认的规则)
//开启负载均衡,并指定规则(包括自定义规则)     这边只获得提供规则的类
@RibbonClient(name = "springcloud-tigong-ip",configuration = RuleConfig.class)
public class Dept_Xiaofei_80 {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Xiaofei_80.class, args);
    }
}
