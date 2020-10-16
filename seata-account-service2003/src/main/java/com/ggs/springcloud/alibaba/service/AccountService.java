package com.ggs.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:42
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
