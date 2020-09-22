package com.ggs.springcloud.service;

import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Starbug
 * @Date 2020/9/22 12:31
 * @FeignClient: 到Eureka注册中心获取名为CLOUD-PROVIDER-PAYMENT的服务
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {

    @GetMapping("payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") int id);

    @GetMapping("payment/server/port")
    String getServerPort();
}
