package com.leon.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.leon.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
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
     * 服务降级
     * @param id
     * @return
     */
    @Override
    //超时的时候执行fallback方法
    @HystrixCommand(fallbackMethod = "paymentInfoError_Handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoError(Integer id) {
        int time = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池   " + Thread.currentThread().getName()
                + "paymentInfoError, id: " + id + "\t" + "耗时" + time + "秒";
//        int age = 10 / 0;
//        return "线程池   " + Thread.currentThread().getName()
//                + "paymentInfoError, id: " + id;
    }
    public String paymentInfoError_Handler(Integer id) {
        return "线程池   " + Thread.currentThread().getName()
                + "paymentInfoError_Handler, id: " + id + "\t" + "我来兜底呜呜呜";
    }
    /**
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期 ms
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸,百分比
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 超时处理
    })
    public String PaymentCircuitBreaker(Integer id) {
        if(id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
//       等同于 String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "\t" + "调用成功,流水号: " + serialNumber;
    }
    public String paymentCircuitBreakerFallback(Integer id) {
        return "id不能为负数，请重新尝试~~~id: " + id;
    }

}
