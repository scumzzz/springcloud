package com.leon.springcloudalibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leon.springcloud.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(400, "按客戶自定义,global handlerException----1");
    }


    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(400, "按客戶自定义,global handlerException----2");
    }
}
