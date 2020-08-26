package com.ebay.ironbank.controllers;

import com.ebay.ironbank.model.Product;

import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
public interface ProductValidator {
    Optional<String> validate(Product product);
}
