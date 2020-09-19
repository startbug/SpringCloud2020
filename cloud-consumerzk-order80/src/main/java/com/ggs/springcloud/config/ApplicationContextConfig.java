package com.ggs.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Starbug
 * @Date 2020/9/18 14:15
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * 当同一个服务名称有多个节点时,如果不添加@LoadBalanced,会报错
     * 原因: 我们通过注册在注册中心的服务的名称来调用服务,但一个服务有多个节点,
     * RestTemplate不知道该找哪一个,所以我们必须要有一个选择策略,所以要添加该注解,默认是轮询策略
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
