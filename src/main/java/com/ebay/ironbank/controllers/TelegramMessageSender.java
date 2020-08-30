package com.ebay.ironbank.controllers;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class TelegramMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println(message+"  was sent by telegram");
    }

    @Override
    public String getMyDeliverType() {
        return "telegram";
    }
}
