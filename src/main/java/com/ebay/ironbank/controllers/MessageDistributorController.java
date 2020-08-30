package com.ebay.ironbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@RestController
public class MessageDistributorController {


    @Autowired
    private Map<String, MessageSender> map;


    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody Message message) {
        String deliveryType = message.getDeliveryType();
        MessageSender messageSender = map.get(deliveryType);
        if (messageSender == null) {
            throw new UnsupportedOperationException(deliveryType + " not supported yet, please consider adding a MessageSenderBean with name = " + deliveryType);
        }
        messageSender.send(message);
    }


}







