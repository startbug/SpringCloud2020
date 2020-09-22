package com.ggs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Starbug
 * @Date 2020/9/22 12:27
 * 使用OpenFeign步骤
 * 1.导入依赖spring-cloud-starter-openfeign
 * 2.使用注解@EnableFeignClients开启OpenFeign功能
 * 3.编写接口,与提供方(provider)方法签名对应
 * 4.接口添加@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")注解, 指定微服务名称
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
