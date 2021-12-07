package com.assuse.koala.rabbit.provider.controller;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class KoalaDeclareAmq implements CommandLineRunner {
    @Autowired
    private AmqpAdmin rabbitTemplate;

    /**
     * 项目启动时创建队列
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.declareExchange(new FanoutExchange("assuse_fanout_exchange"));
        rabbitTemplate.declareQueue(new Queue("assuse_queue"));
        rabbitTemplate.declareBinding(new Binding("assuse_queue", Binding.DestinationType.QUEUE,
                "assuse_fanout_exchange", "", null));
    }
}
