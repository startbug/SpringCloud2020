package com.ggs.springcloud.controller;

import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.service.PaymentFeignService;
import com.ggs.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/9/22 12:37
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable(value = "id") int id) {
        return paymentFeignService.getById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String getServerPort(){
        //提供方中设置了睡眠3s
        //而openfeign-ribbon客户端一般只等待1秒钟
        //可以通过配置修改建立连接等待时长和等待提供方程序执行等待时长
        return paymentFeignService.getServerPort();
    }
}
