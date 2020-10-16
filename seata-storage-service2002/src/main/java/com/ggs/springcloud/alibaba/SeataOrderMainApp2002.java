package com.ggs.springcloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:08
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.ggs.springcloud.alibaba.dao")
public class SeataOrderMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2002.class, args);
    }
}
