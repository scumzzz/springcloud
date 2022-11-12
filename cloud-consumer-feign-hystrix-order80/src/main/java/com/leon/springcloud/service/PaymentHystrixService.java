package com.leon.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {
    @RequestMapping(value = "/payment/hystrix/ok", method = RequestMethod.GET)
    public String paymentInfoOk(@RequestParam("id") Integer id);

    @RequestMapping(value = "/payment/hystrix/error", method = RequestMethod.GET)
    public String paymentInfoError(@RequestParam("id") Integer id);
}
