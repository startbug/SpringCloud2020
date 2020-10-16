package com.ggs.springcloud.alibaba.service;

import com.ggs.springcloud.vo.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author Starbug
 * @Date 2020/10/16 10:46
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult payment(Long id) {
        return new CommonResult(444, "消费者端的兜底方法,provider无法正常运行");
    }
}
