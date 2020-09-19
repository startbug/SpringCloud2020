package com.ggs.springcloud.service;

import com.ggs.springcloud.entities.Payment;

/**
 * @Author Starbug
 * @Date 2020/9/14 12:24
 */
public interface PaymentService {

    int insert(Payment payment);

    Payment getById(int id);

}
