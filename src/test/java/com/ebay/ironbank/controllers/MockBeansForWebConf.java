package com.ebay.ironbank.controllers;

import com.ebay.ironbank.model.Bank;
import com.ebay.ironbank.services.BankService;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
@TestConfiguration
public class MockBeansForWebConf {



    @Bean
    public BankService bankServiceMock() {
        System.out.println("mocks were configured");
        BankService bankService = Mockito.mock(BankService.class);
        Mockito.when(bankService.loan("stark", 1)).thenReturn(false);
        Mockito.when(bankService.loan("lanister", 1)).thenReturn(true);
        return bankService;
    }
}
