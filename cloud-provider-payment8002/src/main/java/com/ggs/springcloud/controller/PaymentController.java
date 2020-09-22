package com.ggs.springcloud.controller;

import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.service.PaymentService;
import com.ggs.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author Starbug
 * @Date 2020/9/14 12:26
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {

        int insert = paymentService.insert(payment);
        log.info("*******插入结果:{}", insert);

        if (insert > 0) {
            return new CommonResult<Integer>(200, serverPort + "Server:success", insert);
        } else {
            return new CommonResult(444, "failed");
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") int id) {
        log.info("查询id为{}的用户 O(∩_∩)O 皇后", id);
        Payment payment = paymentService.getById(id);

        if (null != payment) {
            return new CommonResult(200, serverPort + "Server:success", payment);
        } else {
            return new CommonResult(444, "failed");
        }

    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("payment/server/port")
    public String getServerPort() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
