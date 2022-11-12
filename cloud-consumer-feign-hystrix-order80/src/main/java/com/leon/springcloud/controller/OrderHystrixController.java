package com.leon.springcloud.controller;


import com.leon.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @RequestMapping(value = "/consumer/payment/hystrix/ok", method = RequestMethod.GET)
    public String paymentInfoOk(@RequestParam("id") Integer id){
        String result = paymentHystrixService.paymentInfoOk(id);
        return result;
    }

    @RequestMapping(value = "/consumer/payment/hystrix/error", method = RequestMethod.GET)
    public String paymentInfoError(@RequestParam("id") Integer id){
        String result = paymentHystrixService.paymentInfoError(id);
        return result;
    }
}
