package com.leon.springcloudalibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @SentinelResource("common")
    public String common() {
        return "common";
    }
}
