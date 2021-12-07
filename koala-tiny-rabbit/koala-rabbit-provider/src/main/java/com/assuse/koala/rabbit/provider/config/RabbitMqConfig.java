package com.assuse.koala.rabbit.provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class RabbitMqConfig {
    /**
     * 交换机
     */
    private static final String KOALA_RABBIT_EXCHANGE = "koala_rabbit_exchange";

    /**
     * 队列名
     */
    private static final String KOALA_RABBIT_QUEUE = "koala_rabbit_queue";

    /**
     * 主机host
     */
    @Value("${spring.rabbitmq.host}")
    private String host;

    /**
     * 端口
     */
    @Value("${spring.rabbitmq.port}")
    private int port;

    /**
     * 用户名
     */
    @Value("${spring.rabbitmq.username}")
    private String username;

    /**
     * 密码
     */
    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(this.jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue(KOALA_RABBIT_QUEUE);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(KOALA_RABBIT_EXCHANGE);
    }


    /**
     * 队列绑定到交换机上
     *
     * @return
     */
    @Bean
    public Binding bindingExchangeQueue() {
        return BindingBuilder.bind(queue()).to(exchange());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
