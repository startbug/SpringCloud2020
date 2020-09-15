package com.ggs.springcloud.service.impl;

import com.ggs.springcloud.entities.Payment;
import com.ggs.springcloud.mapper.PaymentMapper;
import com.ggs.springcloud.mapper.PaymentMapper;
import com.ggs.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/9/14 12:24
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int insert(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getById(int id) {
        return paymentMapper.getById(id);
    }
}
