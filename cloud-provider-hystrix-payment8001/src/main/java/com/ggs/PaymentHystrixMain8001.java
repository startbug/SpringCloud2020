package com.ggs;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

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

    /**
     * 此配置是为了服务监控而配置,与服务容错本身无关,SpringCloud升级后的坑
     * ServletRegistrationBean因为SpringBoot默认路径不是"/hystrix.stream",
     * 只要在自己的项目上下文中配置Servlet即可
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
