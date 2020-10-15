package com.ggs.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Starbug
 * @Date 2020/10/15 20:50
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationContextConfig84 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationContextConfig84.class, args);
    }
}
