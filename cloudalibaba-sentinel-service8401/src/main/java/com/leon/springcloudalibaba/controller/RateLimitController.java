package com.leon.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leon.springcloud.entities.CommonResult;
import com.leon.springcloud.entities.Payment;
import com.leon.springcloudalibaba.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimitController {

    @RequestMapping(value = "/byResource", method = RequestMethod.GET)
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2022L, "serial2022"));
    }
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(400, exception.getClass().getCanonicalName() + "\t" + " 服务不可用");
    }

    @RequestMapping(value = "/rateLimit/byUrl", method = RequestMethod.GET)
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    @RequestMapping(value = "/customerBlockHandler", method = RequestMethod.GET)
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}
