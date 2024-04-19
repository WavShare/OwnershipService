package com.wavshare.OwnershipService.controllers;

import com.wavshare.OwnershipService.messaging.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnershipController {

    private final Producer producer;

    @Autowired
    public OwnershipController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/message/{message}")
    public String sendMessage(@PathVariable String message) {
        producer.sendMessageToEmail(message);
        return "Message sent";
    }
}
