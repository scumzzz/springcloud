package com.leon.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leon.springcloudalibaba.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FlowLimitController {

    @Resource
    private CommonService commonService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        log.info(Thread.currentThread().getName() + "\t" + ".......test1");
        return commonService.common();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() {
        return "----------test2";
    }
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public String test3() {
        log.info("test3 异常比例");
        int age = 10 / 0;
        return "----------test3";
    }
    @RequestMapping(value = "/test4", method = RequestMethod.GET)
    @SentinelResource(value = "test4", blockHandler = "deal_test4")
    public String test4(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2) {

        return "----------test4 success";
    }
    public String deal_test4(String p1, String p2, BlockException exception) {

        return "----------test4 兜底";
    }
}
