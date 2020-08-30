package com.ebay.ironbank.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyServicesConfForTests.class)
class BankServiceImplTest {


    @Autowired
    BankService bankService;

    @Test
    void loan() {
        boolean accepted = bankService.loan("stark", 1);
        Assert.assertFalse(accepted);
    }
}