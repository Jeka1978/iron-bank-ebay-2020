package com.ebay.ironbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

/**
 * @author Evgeny Borisov
 */

@Configuration
public class DeliveryConf {


    @EbaySenderBean
    public Map<String,MessageSender> messageSenderMap (List<MessageSender> messageSenders) {
        return messageSenders.stream().collect(Collectors.toMap(MessageSender::getMyDeliverType, identity()));
    }
}
