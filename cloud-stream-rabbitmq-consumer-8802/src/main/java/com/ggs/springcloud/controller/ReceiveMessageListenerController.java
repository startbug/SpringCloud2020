package com.ggs.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @Author Starbug
 * @Date 2020/10/11 22:36
 */
@Controller
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(value = Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1接收消息---> " + message.getPayload() + "\t端口号:" + serverPort);
    }
}
