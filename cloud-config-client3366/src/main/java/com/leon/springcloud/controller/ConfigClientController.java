package com.leon.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverport;

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping(value = "/configInfo", method = RequestMethod.GET)
    public String getConfigInfo() {
        return "serverport: " + serverport + "\t\n\n  configInfo: " + configInfo;
    }
}
