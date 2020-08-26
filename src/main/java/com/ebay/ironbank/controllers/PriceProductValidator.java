package com.ebay.ironbank.controllers;

import com.ebay.ironbank.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
@Service
public class PriceProductValidator implements ProductValidator {
    @Override
    public Optional<String> validate(Product product) {
        if (product.getPrice() < 0) {
            return Optional.of("price can't be negative");
        }
        return Optional.empty();
    }
}
