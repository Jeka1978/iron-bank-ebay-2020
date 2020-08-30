package com.ebay.ironbank.services;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@TestConfiguration
@ComponentScan
public class MyServicesConfForTests {

    @Bean
    public BankService bankService(){
        return new BankServiceImpl();
    }
}
