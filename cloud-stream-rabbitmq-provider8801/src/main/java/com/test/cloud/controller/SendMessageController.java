package com.test.cloud.controller;


import com.test.cloud.service.IMessageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageService messageService;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        String send = messageService.send();
        return send;
    }

}