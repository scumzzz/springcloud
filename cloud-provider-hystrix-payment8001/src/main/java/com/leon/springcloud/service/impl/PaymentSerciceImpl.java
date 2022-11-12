package com.leon.springcloud.service.impl;

import com.leon.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentSerciceImpl implements PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    @Override
    public String paymentInfoOk(Integer id) {
        return "线程池   " + Thread.currentThread().getName()
                + "paymentInfoOk, id: " + id + "\t" + "正确的，中肯的";
    }

    /**
     * 错误访问
     * @param id
     * @return
     */
    @Override
    public String paymentInfoError(Integer id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池   " + Thread.currentThread().getName()
                + "paymentInfoError, id: " + id + "\t" + "耗时" + time ;
    }
}
