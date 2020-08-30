package com.ebay.ironbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@RestController
public class MessageDistributorController {


    private Map<String, MessageSender> messageSenderMap = new HashMap<>();


    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody Message message) {
        String deliveryType = message.getDeliveryType();
        MessageSender messageSender = messageSenderMap.get(deliveryType);
        if (messageSender == null) {
            throw new UnsupportedOperationException(deliveryType + " not supported yet, please consider adding a MessageSenderBean with name = " + deliveryType);
        }
        messageSender.send(message);
    }


    public void register(String deliveryType, MessageSender messageSender) {
        if (messageSenderMap.containsKey(deliveryType)) {
            throw new IllegalStateException(deliveryType + " supported by two classes");
        }
        messageSenderMap.put(deliveryType, messageSender);
    }


}







