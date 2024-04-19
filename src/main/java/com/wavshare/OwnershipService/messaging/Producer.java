package com.wavshare.OwnershipService.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageToEmail(String message) {
        rabbitTemplate.convertAndSend("ownership_email", message);
        System.out.println("Sent '" + message + "' to queue 'ownership_email'");
    }
}
