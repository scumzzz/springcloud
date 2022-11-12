package com.leon.springcloud.service;


import com.leon.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    CommonResult getPaymentById(@RequestParam("id") Long id);

    @RequestMapping(value = "/payment/feign/timeout", method = RequestMethod.GET)
    String PaymentFeignTimeout();

}
