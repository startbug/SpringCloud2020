package com.ggs.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Starbug
 * @Date 2020/10/11 22:53
 */
@Controller
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(value = Sink.INPUT)
    public void sendMessage(Message<String> message) {
        System.out.println("端口号:" + serverPort + "\t" + "信息:" + message.getPayload());
    }


}
