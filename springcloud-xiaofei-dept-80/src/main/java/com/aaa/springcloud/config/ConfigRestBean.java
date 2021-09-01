package com.aaa.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//声明为配置类
@Configuration
public class ConfigRestBean {

    //在容器中配置bean
    //把RestTemplate放入IOC容器，不用new，达到解耦
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
