package com.ggs.springcloud.controller;

import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.vo.CommonResult;
import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/9/15 19:31
 */
@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 通过restTempate发送json格式的数据,需要将接受的数据转成json串
     * 通过HttpHeaders设置请求头,指定传送的数据是json格式的数据
     * 将HttpHeaders封装到HttpEntity对象中,然后放入restTemplate中发送即可
     *
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(/*@RequestBody*/ Payment payment) {
//        Gson gson = new Gson();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> httpEntity = new HttpEntity<>(gson.toJson(payment), httpHeaders);

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
