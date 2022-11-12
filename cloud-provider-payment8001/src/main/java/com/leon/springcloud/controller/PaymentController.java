package com.leon.springcloud.controller;

import com.leon.springcloud.entities.CommonResult;
import com.leon.springcloud.entities.Payment;
import com.leon.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("插入的结果为:" + result);
        if(result > 0) {
            return new CommonResult(200, "插入成功,serverPort： " + serverPort, result);
        } else {
            return new CommonResult(400,"插入失败", null);
        }
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public CommonResult getPaymentById(@RequestParam Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("查询的结果为:" + payment);
        if(payment != null) {
            return new CommonResult(200, "查修成功,serverPort："+ serverPort, payment);
        } else {
            return new CommonResult(400,"查修失败", null);
        }
    }

    @RequestMapping(value = "/payment/lb", method = RequestMethod.GET)
    public String getPaymentLB() {
        return serverPort;
    }

    @RequestMapping(value = "/payment/feign/timeout", method = RequestMethod.GET)
    public String PaymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
