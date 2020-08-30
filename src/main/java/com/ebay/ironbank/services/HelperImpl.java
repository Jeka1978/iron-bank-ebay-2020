package com.ebay.ironbank.services;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
public class HelperImpl implements Helper {
    @Override
//    @Scheduled(fixedDelay = 1000)
    public void help() {
        System.out.println("help");
    }


}
