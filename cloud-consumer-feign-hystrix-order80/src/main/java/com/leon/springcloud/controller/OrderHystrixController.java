package com.leon.springcloud.controller;


import com.leon.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @RequestMapping(value = "/consumer/payment/hystrix/ok", method = RequestMethod.GET)
    public String paymentInfoOk(@RequestParam("id") Integer id){
        String result = paymentHystrixService.paymentInfoOk(id);
        return result;
    }

    @RequestMapping(value = "/consumer/payment/hystrix/error", method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "paymentInfoErrorFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    public String paymentInfoError(@RequestParam("id") Integer id){
//        int age = 10 / 0;
        String result = paymentHystrixService.paymentInfoError(id);
        return result;
    }
    public String paymentInfoErrorFallback(@RequestParam("id") Integer id){
        return "我是消费者80,对方支付系统繁忙，请10秒后再试";
    }

    public String payment_Global_FallbackMethod() {
        return "全局异常处理信息，请稍后重试";
    }
}
