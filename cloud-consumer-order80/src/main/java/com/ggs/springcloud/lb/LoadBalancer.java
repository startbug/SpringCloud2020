package com.ggs.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Starbug
 * @Date 2020/9/21 22:48
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> instances);
}
