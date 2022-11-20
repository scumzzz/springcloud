package com.leon.springcloudalibaba.service;


import com.leon.springcloud.entities.CommonResult;
import com.leon.springcloud.entities.Payment;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4001, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}