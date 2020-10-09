package com.ggs.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Starbug
 * @Date 2020/10/7 19:10
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        RouteLocator routeLocator = routes.route("path_route_ggs", p -> p.path("/guonei").uri("http://news.baidu.com/guonei")).route("mtime",p->p.path("/movie").uri("http://www.mtime.com")).build();

        return routeLocator;
    }

}
