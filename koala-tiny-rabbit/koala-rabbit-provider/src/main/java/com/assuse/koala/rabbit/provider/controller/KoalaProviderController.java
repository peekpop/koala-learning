package com.assuse.koala.rabbit.provider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class KoalaProviderController {
    private static final String KOALA_RABBIT_EXCHANGE = "koala_rabbit_exchange";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public void sentMessage() {
        rabbitTemplate.convertAndSend(KOALA_RABBIT_EXCHANGE, null, "测试消息");
    }
}
