package com.ggs.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:35
 */
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
