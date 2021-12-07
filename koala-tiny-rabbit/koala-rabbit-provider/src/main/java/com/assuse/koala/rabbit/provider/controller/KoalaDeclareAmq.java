package com.assuse.koala.rabbit.provider.controller;

import com.assuse.koala.rabbit.provider.constant.RabbitMqConstant;
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
        rabbitTemplate.declareExchange(new FanoutExchange(RabbitMqConstant.FANOUT_EXCHANGE));
        rabbitTemplate.declareQueue(new Queue(RabbitMqConstant.FANOUT_QUEUE));
        rabbitTemplate.declareBinding(new Binding(RabbitMqConstant.FANOUT_QUEUE, Binding.DestinationType.QUEUE,
                RabbitMqConstant.FANOUT_EXCHANGE, "assuse_info", null));
    }
}
