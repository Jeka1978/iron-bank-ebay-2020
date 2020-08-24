package com.ebay.ironbank.services;/**
 * @author Evgeny Borisov
 */

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Autowired
public @interface EbayAutowired {
}
