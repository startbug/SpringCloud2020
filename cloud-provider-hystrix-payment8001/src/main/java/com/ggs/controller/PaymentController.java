package com.ggs.controller;

import cn.hutool.core.util.IdUtil;
import com.ggs.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Starbug
 * @Date 2020/9/22 18:58
 *
 * 小结:
 * 熔断打开(open状态): 请求不在进行调用当前服务,内部设置时钟一般为MTTR(平均故障处理时间),当打开时长达到所设时钟则进入半熔断状态
 * 熔断关闭(close状态): 熔断关闭不会对服务进行熔断
 * 熔断半开(half-open状态): 部分请求根据规则调用当前服务,如果请求成功且符合规则则认为当前服务恢复正常,熔断关闭
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("***********result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("***********result: `" + result);
        return result;
    }


    //测试服务熔断

    /**
     * @param id
     * @return
     * 服务熔断的效果
     * 当输入负数时,service层会抛出异常,就会调用降级fallback方法
     * 当在指定时间内,失败率达到60%,就会触发熔断,熔断后,即使输入的是正数,也不会有正确的响应
     * 当多次输入正数后,失败率降低60%以下或者到了下一个窗口期(10s),则会恢复正常响应
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: " + result);
        return result;
    }

}
