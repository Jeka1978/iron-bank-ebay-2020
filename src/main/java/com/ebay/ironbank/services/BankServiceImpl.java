package com.ebay.ironbank.services;

import com.ebay.ironbank.model.Bank;
import com.ebay.ironbankrulesstarter.ConditionOnProd;
import com.ebay.ironbankrulesstarter.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

/**
 * @author Evgeny Borisov
 */
@EbayService
@ConditionOnProd
public class BankServiceImpl implements BankService {


    @InjectChuckNorrisQuote
    private String quote;
    @Autowired
    private PredictionService predictionService;

    @PostConstruct
    public void init() {
        System.out.println("quote = " + quote);
    }


    @EbayAutowired
    private BankDao bankDao;

    @Autowired
    private Helper helper;


    @EventListener(ContextRefreshedEvent.class)
    @Transactional
    public void initializeBankAffiliates(ContextRefreshedEvent event) {
        Bank bank = Bank.builder().balance(100).build();
        bankDao.save(bank);
    }

    @Override
    public long getBalance() {
        return bankDao.findAll().stream().mapToLong(Bank::getBalance).sum();
    }


    @Override
    @PreDestroy
    public void closeBank() {
        System.out.println("total balance is: " + bankDao.findAll().get(0).getBalance());

    }

    @Override
    public boolean loan(String name, int amount) {
        Bank bank = bankDao.findAll().get(0);
        if (amount > bank.getBalance()) {
            throw new NotEnoughMoneyException("not enough money in the bank");
        }

        if (predictionService.willSurvive(name)) {
            bank.setBalance(bank.getBalance() - amount);
            return true;
        } else {
            return false;
        }


    }


}








