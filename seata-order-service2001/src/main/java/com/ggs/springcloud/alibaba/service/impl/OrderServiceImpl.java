package com.ggs.springcloud.alibaba.service.impl;

import com.ggs.springcloud.alibaba.dao.OrderDao;
import com.ggs.springcloud.alibaba.domain.Order;
import com.ggs.springcloud.alibaba.service.AccountService;
import com.ggs.springcloud.alibaba.service.OrderService;
import com.ggs.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/10/16 16:13
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单-->调用库存服务扣减库存-->调用账户服务扣减账户余额-->修改账单状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "ggs-create-order", rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("--------->创建订单中");
        //1.新建账单
        orderDao.createOrder(order);

        log.info("开始调用微服务进行库存扣减");
        //2.扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("扣减库存成功!");

        log.info("开始调用微服务对用户账户资金进行扣减");
        //3.扣减资金
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("扣减资金成功!");

        log.info("修改订单状态: 未支付--->已支付");
        //4.修改用户订单状态
        orderDao.updateOrder(order.getUserId(), 0);
        log.info("修改账单状态成功!");
    }
}
