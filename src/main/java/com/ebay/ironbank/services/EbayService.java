package com.ebay.ironbank.services;/**
 * @author Evgeny Borisov
 */

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Service
@Transactional
public @interface EbayService {
}
