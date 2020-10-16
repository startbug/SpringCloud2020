package com.ggs.springcloud.alibaba.service;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:13
 */
public interface StorageService {

    void decrease(Long productId, Integer count);

}
