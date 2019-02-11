package com.cyh.consumer.service;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yunhai.chen
 * @date 2018/9/4 9:19<br>
 * Description:
 **/
@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private final String EXCHANGE_NAME = "test_exchange";
    private final String QUEUE_NAME = "test_queue";
    private final String ROUTING_KEY = "test_route";
    private Channel channel;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    private final AmqpTemplate amqpTemplate;

    public Consumer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @PostConstruct
    public void init() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        Connection connection = connectionFactory.newConnection(new Address[]{new Address(host, port)});
        channel = connection.createChannel();
        channel.basicQos(2);
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
                logger.info("consumer message: {}", new String(bytes));
//                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    @Scheduled(fixedRate = 1000L)
    public void consumer() throws Exception {
        Thread.sleep(1000L);
    }
}
