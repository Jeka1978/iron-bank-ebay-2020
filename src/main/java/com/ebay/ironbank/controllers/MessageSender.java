package com.ebay.ironbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
public interface MessageSender {

    void send(Message message);

    String getMyDeliverType();

    @Autowired
    default void register(MessageDistributorController controller) {
        controller.register(getMyDeliverType(), this);
    }


}
