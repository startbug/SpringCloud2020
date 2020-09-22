package com.ggs.springcloud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.lb.MyLb;
import com.ggs.springcloud.vo.CommonResult;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author Starbug
 * @Date 2020/9/15 19:31
 */
@RestController
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private MyLb myLb;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/consumer/payment/get/entity/{id}")
    public CommonResult<Payment> getById2(@PathVariable Long id) throws JsonProcessingException {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        System.out.println(new ObjectMapper().writeValueAsString(forEntity));
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult(444, "Failed");
        }
    }

    @PostMapping("/consumer/payment/post/create")
    public CommonResult<Payment> createOrder(Payment payment) throws JsonProcessingException {
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        System.out.println(new ObjectMapper().writeValueAsString(commonResultResponseEntity));
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful()) {
            return commonResultResponseEntity.getBody();
        } else {
            return new CommonResult(444, "Failed");
        }
    }


    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = myLb.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }


}
