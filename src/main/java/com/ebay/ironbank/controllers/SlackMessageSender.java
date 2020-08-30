package com.ebay.ironbank.controllers;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class SlackMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println(message+" sent by slack");
    }

    @Override
    public String getMyDeliverType() {
        return "slack";
    }
}
