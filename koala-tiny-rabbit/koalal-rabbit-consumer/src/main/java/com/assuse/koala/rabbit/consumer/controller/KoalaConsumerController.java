package com.assuse.koala.rabbit.consumer.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.channels.Channel;
import java.nio.charset.StandardCharsets;

@Component
public class KoalaConsumerController {

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "koala_rabbit_queue"), exchange = @Exchange("koala_rabbit_exchange"))})
    public void receiveMsg(Message message) {
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println(msg);
    }
}
