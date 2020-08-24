package com.ebay.ironbank.services;

import com.ebay.ironbank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface BankDao extends JpaRepository<Bank,Integer> {


    List<Bank> findByBalanceGreaterThan(long amount);

}