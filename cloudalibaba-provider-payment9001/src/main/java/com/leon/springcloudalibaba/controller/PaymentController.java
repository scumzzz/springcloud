package com.leon.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/nacos", method = RequestMethod.GET)
    public String getPayment(@RequestParam Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }
}
