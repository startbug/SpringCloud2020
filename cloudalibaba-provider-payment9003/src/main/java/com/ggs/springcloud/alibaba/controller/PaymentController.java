package com.ggs.springcloud.alibaba.controller;

import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.vo.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author Starbug
 * @Date 2020/10/15 20:36
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Long, Payment> map = new HashMap<>();

    static {
        map.put(1L, new Payment(1L, "111111111lucy aaaaaaa"));
        map.put(2L, new Payment(2L, "222222222lucy bbbbbbb"));
        map.put(3L, new Payment(3L, "333333333lucy ccccccc"));
        map.put(4L, new Payment(4L, "444444444lucy ddddddd"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult payment(@PathVariable("id") Long id) {
        return new CommonResult(200, "search success", map.get(id));
    }
}

