package com.ggs.springcloud.controller;

import com.ggs.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/10/11 21:53
 *
 * 发送消息,8802和8803会重复消费,我们希望两个服务是竞争的关系,则需要将同类服务放到一个组中即可
 * 故障现象: 重复消费
 * 导致原因: 默认分组group是不同的,组流水号不一样,被认为是不同组,可以消费
 * 原理: 微服务应放置于同一个group中,就能保证消息只会被其中一个应用消费一次
 *       不同的组是可以消费的,同一个组内会发生竞争关系,只有其中一个可以消费
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send/message")
    public String sendMessage() {
        return messageProvider.send();
    }


}
