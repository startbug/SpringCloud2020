package com.ggs.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:15
 */
public interface StorageDao {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
