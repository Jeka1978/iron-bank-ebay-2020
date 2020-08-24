package com.ebay.ironbank.services;

import com.ebay.ironbank.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @author Evgeny Borisov
 *
 *
 */
//@Component
//@Transactional
//public class EbayContextListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private BankDao bankDao;
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        Bank bank = Bank.builder().balance(100).build();
//        bankDao.save(bank);
//    }
//}
