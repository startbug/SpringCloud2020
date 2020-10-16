package com.ggs.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Starbug
 * @Date 2020/10/15 20:50
 *
 * 整合openfeign
 * 1.导入spring-cloud-starter-openfeign
 * 2.修改配置,激活Sentinel对Feign额支持 feign.sentinel.enabled: true
 * 3.主启动类添加@EnableFeignClients注解(自带负载均衡)
 * 4.编写接口PaymentService,编写fallback类
 * 5.在接口编写接口PaymentService中添加注解@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
 *
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ApplicationContextConfig84 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationContextConfig84.class, args);
    }
}
