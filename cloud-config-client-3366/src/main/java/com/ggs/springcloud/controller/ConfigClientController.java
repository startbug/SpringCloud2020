package com.ggs.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Starbug
 * @Date 2020/10/10 18:46
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String info;

    @GetMapping("/get/info")
    public String getInfo() {
        return "server port: " + port + "\t" + " config info:" + info;
    }

}
