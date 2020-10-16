package com.ggs.springcloud.alibaba.controller;

import com.ggs.springcloud.alibaba.domain.CommonResult;
import com.ggs.springcloud.alibaba.domain.Order;
import com.ggs.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/10/16 16:40
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult createOrder(Order order) {
        orderService.createOrder(order);
        return new CommonResult(200, "创建订单成功");
    }

}
