package com.ggs.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ggs.springcloud.alibaba.handler.CustomerBlockHandler;
import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.vo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Starbug
 * @Date 2020/10/15 18:26
 */
@RestController
public class RateLimitController {

    @GetMapping("/by/resource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException blockException) {
        return new CommonResult(444, blockException.getClass().getCanonicalName() + "\t服务不可用");
    }


    @GetMapping("/customer/block/handler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按照客户自定义限流处理逻辑");
    }

}
