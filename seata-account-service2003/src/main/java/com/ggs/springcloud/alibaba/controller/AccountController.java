package com.ggs.springcloud.alibaba.controller;

import com.ggs.springcloud.alibaba.domain.CommonResult;
import com.ggs.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author Starbug
 * @Date 2020/10/16 17:34
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "Provider扣减用户基金成功");
    }


}
