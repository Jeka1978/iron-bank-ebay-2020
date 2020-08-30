package com.ebay.ironbank.controllers;

/**
 * @author Evgeny Borisov
 */
public interface MessageSender {

    void send(Message message);

    String getMyDeliverType();
}
