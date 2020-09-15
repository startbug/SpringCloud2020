package com.ggs.springcloud.controller;

import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.service.PaymentService;
import com.ggs.springcloud.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/9/14 12:26
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {

        int insert = paymentService.insert(payment);
        log.info("*******插入结果:{}", insert);

        if (insert > 0) {
            return new CommonResult<Integer>(200, "success", insert);
        } else {
            return new CommonResult(444, "failed");
        }
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") int id) {
        log.info("查询id为{}的用户 O(∩_∩)O 皇后", id);
        Payment payment = paymentService.getById(id);

        if (null != payment) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(444, "failed");
        }

    }

}