package com.aaa.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//添加mapperscan注解，扫描mapper层，不然报找不到bean
@MapperScan("com.aaa.springcloud.mapper")
public class Dept_Tigong_8001 {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Tigong_8001.class, args);
    }
}
