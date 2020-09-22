package com.ggs.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/9/21 11:53
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public String orderConsul() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }


}
