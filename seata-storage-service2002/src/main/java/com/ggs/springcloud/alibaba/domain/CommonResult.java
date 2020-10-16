package com.ggs.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    Integer code;
    String message;
    T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
