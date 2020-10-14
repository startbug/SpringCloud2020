package com.ggs.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Starbug
 * @Date 2020/10/14 22:13
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "xxxxx testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "yyyyy testB";
    }
}
