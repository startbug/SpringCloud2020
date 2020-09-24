package com.ggs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Starbug
 * @Date 2020/9/22 19:02
 * <p>
 * 1.使用@EnableCircuitBreaker启用服务熔断机制
 * 2.在方法上添加@HystrixCommand,指定fallback方法和超时时间
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }

}
