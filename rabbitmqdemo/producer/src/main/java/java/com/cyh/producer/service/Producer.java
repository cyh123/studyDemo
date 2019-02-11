package java.com.cyh.producer.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yunhai.chen
 * @date 2018/9/3 20:00<br>
 * Description:
 **/
@Service
public class Producer {
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final String EXCHANGE_NAME = "test_exchange_2";
    private final String QUEUE_NAME = "test_queue_2";
    private final String ROUTING_KEY = "test_route_2";
    private Channel channel;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private Integer port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @PostConstruct
    public void init() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPort(port);
        connectionFactory.setHost(host);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        Connection connection = connectionFactory.newConnection();
        channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
        channel.queueDeclare(QUEUE_NAME, true, false,false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        channel.addReturnListener((replyCode, replyText, exchange, routingKey, properties, body) -> {
        } );
    }

    @Scheduled(fixedRate = 1000L)
    public void produce() throws IOException {
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, "this is a test".getBytes());
        logger.info("finish to send message");
    }
}
