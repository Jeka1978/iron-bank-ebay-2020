package com.ebay.ironbank.controllers;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class SmsMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println(message+"  was sent by sms");
    }

    @Override
    public String getMyDeliverType() {
        return "sms";
    }
}
