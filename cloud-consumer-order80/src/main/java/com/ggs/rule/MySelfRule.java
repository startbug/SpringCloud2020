package com.ggs.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Starbug
 * @Date 2020/9/21 14:42
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule() {
        return new RandomRule(); //设置Ribbon的负载均衡策略,RandomRule为随机访问策略
    }

}
