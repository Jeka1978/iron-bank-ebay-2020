package com.ebay.ironbank.services;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

/**
 * @author Evgeny Borisov
 */
public interface BankService {
    @EventListener(ContextRefreshedEvent.class)
    @Transactional
    void initializeBankAffiliates(ContextRefreshedEvent event);

    long getBalance();

    void closeBank();

    boolean loan(String name, int amount);

    void veryOld();
}
