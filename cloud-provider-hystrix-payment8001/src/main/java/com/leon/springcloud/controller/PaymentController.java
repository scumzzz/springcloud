package com.leon.springcloud.controller;


import com.leon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @RequestMapping(value = "/payment/hystrix/ok", method = RequestMethod.GET)
    public String paymentInfoOk(@RequestParam Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("*********result:" + result);
        return result;
    }
    @RequestMapping(value = "/payment/hystrix/error", method = RequestMethod.GET)
    public String paymentInfoError(@RequestParam Integer id) {
        String result = paymentService.paymentInfoError(id);
        log.info("*********result:" + result);
        return result;
    }
    @RequestMapping(value = "/payment/circuit")
    public String paymentCircuitBreaker(@RequestParam Integer id) {
        String result = paymentService.PaymentCircuitBreaker(id);
        log.info("******result: " + result);
        return result;
    }
}
