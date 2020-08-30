package com.ebay.ironbank.controllers;

/**
 * @author Evgeny Borisov
 */
public class TeamsMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println("sent by TEAMS");
    }

    @Override
    public String getMyDeliverType() {
        return "teams";
    }
}
