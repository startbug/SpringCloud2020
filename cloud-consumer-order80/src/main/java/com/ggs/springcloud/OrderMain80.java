package com.ggs.springcloud;

import com.ggs.rule.MySelfRule;
import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author Starbug
 * @Date 2020/9/15 19:25
 */
//@Builder
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(value = "CLOUD-PROVIDER-PAYMENT", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
