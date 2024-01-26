package com.rabbit.rabbitmqproject.producer;

import com.rabbit.rabbitmqproject.dto.ValueMessage;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;


@Service
public class RabitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabitMQProducer.class);

    public RabitMQProducer(RabbitTemplate rebbitTemplate){
        this.rabbitTemplate = rebbitTemplate;
    }

    public void sendMessage(ValueMessage message){
        LOGGER.info(String.format("Message sent -> %s",message.toString()));
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
    }

}
