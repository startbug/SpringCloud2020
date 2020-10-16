package com.ggs.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId; //产品id
    private int total;  //总库存
    private int used;   //已经用库存
    private int residue;    //剩余库存
}
