package com.ebay.ironbank.controllers;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component("whatsapp")
public class WhatsappMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println(message+"  was sent by whatsaapp");
    }
}
