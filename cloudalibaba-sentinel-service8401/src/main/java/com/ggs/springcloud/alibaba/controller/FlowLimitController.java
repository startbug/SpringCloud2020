package com.ggs.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author Starbug
 * @Date 2020/10/14 22:13
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "xxxxx testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info("测试异常比例");
        int i = 10 / 0;
        return "yyyyy testB";
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "cccc testC";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testEEEEE 测试异常数");
        int age = 10 / 0;
        return "testEEEEE 测试异常数";
    }

    /**
     *
     * @SentinelResource: 注解中的value可以于GetMapping中的不一样,但是要唯一,通常和路径一样
     *                    value值作为sentinel中热点资源的id(踩坑: 多加了一个 /
     * @return
     */
    @SentinelResource(value = "testF",blockHandler = "fallback_testHotKey")
//    @SentinelResource(value = "testF")
    @GetMapping("/testF")
    public String testF(@RequestParam(value = "p1", required = false) Integer p1,
                        @RequestParam(value = "p2", required = false) Integer p2) {
        int i=10/0;
        return "testFtestFtestFtestF~~~~~";
    }

    public String fallback_testHotKey(Integer p1, Integer p2, BlockException blockException){
        return "-----hot key flow limit /(ㄒoㄒ)/~~ 啊啊";  //sentinel系统默认的提示: Blocked by Sentinel (flow limiting)
    }
}
