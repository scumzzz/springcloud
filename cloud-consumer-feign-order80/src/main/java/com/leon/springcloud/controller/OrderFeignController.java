package com.leon.springcloud.controller;

import com.leon.springcloud.entities.CommonResult;
import com.leon.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/consumer/search", method = RequestMethod.GET)
    public CommonResult getPaymentById(@RequestParam Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @RequestMapping(value = "/consumer/payment/feign/timeout", method = RequestMethod.GET)
    public String PaymentFeignTimeout(){
        return paymentFeignService.PaymentFeignTimeout();
    }
}
