package com.ggs.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author Starbug
 * @Date 2020/9/24 20:01
 *
 * 服务降级处理,和服务提供方实现一样的接口,实现里面的方法,作为fallback
 * 配置后,记得重启注册中心,否则不生效
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fallback paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fallback paymentInfo_TimeOut";
    }
}
