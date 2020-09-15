package com.ggs.springcloud.mapper;

import com.ggs.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Starbug
 * @Date 2020/9/14 12:20
 */
@Mapper
public interface PaymentMapper {

    int insert(Payment payment);

    Payment getById(@Param("id") int id);
}
