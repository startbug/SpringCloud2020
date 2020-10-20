package com.ggs.springcloud.alibaba.service.impl;

import com.ggs.springcloud.alibaba.dao.AccountDao;
import com.ggs.springcloud.alibaba.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:42
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------>Provider开始扣除用户资金");
        //模拟超时异常,全局事务回滚
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId, money);
        log.info("=====>Provider扣除资金成功!");
    }
}
