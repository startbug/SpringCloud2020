package com.ggs.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Starbug
 * @Date 2020/9/15 19:31
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @LoadBalanced(负载均衡)必须要添加该注解,否则无法使用微服务名进行访问其他服务
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
