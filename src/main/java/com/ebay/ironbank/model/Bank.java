package com.ebay.ironbank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Evgeny Borisov
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Bank {


    @Id
    @GeneratedValue
    private int id;


    private long balance;
}
