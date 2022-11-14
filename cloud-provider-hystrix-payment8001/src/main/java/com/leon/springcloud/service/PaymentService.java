package com.leon.springcloud.service;

public interface PaymentService {

    public String paymentInfoOk(Integer id);

    public String paymentInfoError(Integer id);

    public String PaymentCircuitBreaker(Integer id);
}
