package com.qbw.ojbackendjudgeservice.RabbitMq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 10362
 */
@Component
public class MyMessageProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 接受消息
     * @param exchangeName
     * @param routingKey
     * @param message
     */
    public void sendMessage(String exchangeName, String routingKey, String message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
