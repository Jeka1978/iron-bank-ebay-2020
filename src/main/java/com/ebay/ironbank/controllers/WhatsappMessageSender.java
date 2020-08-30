package com.ebay.ironbank.controllers;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class WhatsappMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println(message+"  was sent by whatsaapp");
    }

    @Override
    public String getMyDeliverType() {
        return "whatsapp";
    }
}
