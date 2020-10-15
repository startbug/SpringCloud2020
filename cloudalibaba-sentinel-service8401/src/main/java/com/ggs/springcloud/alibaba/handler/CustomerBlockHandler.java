package com.ggs.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ggs.springcloud.vo.CommonResult;

/**
 * @Author Starbug
 * @Date 2020/10/15 19:04
 */

public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "按照客户自定义限流处理逻辑-------1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按照客户自定义限流处理逻辑-------2");
    }

}
