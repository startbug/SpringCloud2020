package com.ggs.springcloud.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/10/11 21:32
 */
public interface IMessageProvider {
    String send();
}
