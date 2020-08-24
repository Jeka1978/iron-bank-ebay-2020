package com.ebay.ironbank.services;

import javax.annotation.PreDestroy;

/**
 * @author Evgeny Borisov
 */
public interface BankService {
    long getBalance();

    void closeBank();

    boolean loan(String name, int amount);
}
