package com.ggs.springcloud.alibaba.dao;

import com.ggs.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Starbug
 * @Date 2020/10/16 15:58
 */
public interface OrderDao {
    //1 新建订单
    void createOrder(Order order);

    //2 修改订单状态: 从0改为1
    void updateOrder(@Param("userId") Long userId, @Param("status") Integer status);
}
