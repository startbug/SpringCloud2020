package com.ggs.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author Starbug
 * @Date 2020/10/9 12:15
 *
 * 官网:网关过滤器,路由过滤器用于修改进入的Http请求和返回的Http响应,路由过滤器只能指定路由进行使用
 *          Spring Cloud Gateway内置了多种路由过滤器,他们都由GatewayFilter大的工厂类产生
 * 过滤请求,必须携带usernamex,并且不能为空,否则不许访问
 */
@Configuration
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter,Ordered  {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("----------------visit time: "+new Date());

        String usernamex = exchange.getRequest().getQueryParams().getFirst("usernamex");

        if(usernamex==null||"".equals(usernamex)){
            log.info("---------------用户名为空,非法用户,/(ㄒoㄒ)/~~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
