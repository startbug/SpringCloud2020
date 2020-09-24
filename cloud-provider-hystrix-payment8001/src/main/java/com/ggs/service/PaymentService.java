package com.ggs.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author Starbug
 * @Date 2020/9/22 18:55
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "\tPayment_id: " + id + "\t" + "O(∩_∩)O哈哈";
    }

    /**
     * 方法执行需要5秒,但是设置了超时时间为3秒,超过时间则会进行服务降级,调用fallback方法响应给调用方
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int num = 3;
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 10 / 0;
        return "线程池: " + Thread.currentThread().getName() + "\tPayment_id: " + id + ",paymentInfo_TimeOut----\t" + "耗时(秒):" + num + "O(∩_∩)O哈哈";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "\tPayment_id: " + id + ",8001运行出错,paymentInfo_TimeOutHandler----\t" + "/(ㄒoㄒ)/~~";
    }


    //====服务熔断
    //参数解析:开启断路器,当在10秒内,有10个或以上的请求,并且失败率达到60%以上,则触发熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数 -- 请求总数阈值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   //时间窗口期 -- 快照时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //达到失败率后发生熔断 -- 错误百分比阈值
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*******id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功 id = " + id + " ,流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数,请稍后重试,巴拉巴拉";
    }

}
