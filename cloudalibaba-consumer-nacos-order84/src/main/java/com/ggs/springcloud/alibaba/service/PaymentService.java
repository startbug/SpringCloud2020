package com.ggs.springcloud.alibaba.service;

import com.ggs.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Starbug
 * @Date 2020/10/16 10:44
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    CommonResult payment(@PathVariable("id") Long id);

}
