package com.ggs.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Starbug
 * @Date 2020/10/15 20:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9003 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9003.class, args);
    }

}
