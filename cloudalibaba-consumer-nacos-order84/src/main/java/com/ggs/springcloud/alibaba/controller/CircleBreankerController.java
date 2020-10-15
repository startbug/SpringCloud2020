package com.ggs.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Starbug
 * @Date 2020/10/15 20:51
 * @SentinelResource: fallback属性管理运行时异常, blockHandler管配置违规
 */
@RestController
public class CircleBreankerController {

    private static String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")  //fallback 只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置的违规
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback", exceptionsToIgnore = IllegalArgumentException.class)
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/payment/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("该id没有对应记录");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常处理" + e.getMessage(), payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        return new CommonResult<>(444, "兜底异常处理 blockHandler" + blockException.getMessage(), new Payment(id, null));
    }
}
