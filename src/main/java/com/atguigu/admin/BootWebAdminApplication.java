package com.atguigu.admin;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.atguigu.admin.mapper")
@SpringBootApplication
public class BootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminApplication.class, args);
    }

}
