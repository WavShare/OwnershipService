package com.wavshare.OwnershipService.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToEmail(String message) {
        rabbitTemplate.convertAndSend("ownership_email", message);
        System.out.println("Sent '" + message + "' to queue 'ownership_email'");
    }
}
