package com.ggs.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Starbug
 * @Date 2020/10/10 12:21
 *
 *
 * @RefreshScope : 动态刷新配置文件需要添加该注解
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/get/info")
    public String getInfo() {
        return this.info;
    }

}
