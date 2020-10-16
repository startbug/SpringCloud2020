package com.ggs.springcloud.alibaba.controller;

import com.ggs.springcloud.alibaba.domain.CommonResult;
import com.ggs.springcloud.alibaba.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:07
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(
            @RequestParam("productId") Long productId,
            @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "Provider--->扣减库存成功");

    }


}
