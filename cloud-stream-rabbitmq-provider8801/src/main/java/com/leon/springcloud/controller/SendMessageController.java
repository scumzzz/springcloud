package com.leon.springcloud.controller;

import com.leon.springcloud.service.IMessageProviderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProviderService iMessageProviderService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendMessage() {
        return iMessageProviderService.send();
    }
}
