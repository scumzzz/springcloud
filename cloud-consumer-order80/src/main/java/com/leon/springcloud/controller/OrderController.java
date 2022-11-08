package com.leon.springcloud.controller;

import com.leon.springcloud.entities.CommonResult;
import com.leon.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
    }

    @RequestMapping(value = "/consumer/search", method = RequestMethod.GET)
    public CommonResult getPaymentById(@RequestParam Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/search?id=" + id, CommonResult.class);
    }
}
