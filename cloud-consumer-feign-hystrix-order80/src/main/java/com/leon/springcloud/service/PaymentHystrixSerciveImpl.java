package com.leon.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixSerciveImpl implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "----------paymentFallbackService fall back--paymentInfoOk, 降级了";
    }

    @Override
    public String paymentInfoError(Integer id) {
        return "----------paymentFallbackService fall back--paymentInfoError, 降级了";
    }
}
