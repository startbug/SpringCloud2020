package com.ggs.springcloud.alibaba.service.impl;

import com.ggs.springcloud.alibaba.dao.StorageDao;
import com.ggs.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:20
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("-------->Provider开始扣减库存------->");
        storageDao.decrease(productId, count);
        log.info("-------->Provider扣减成功------->");
    }
}
