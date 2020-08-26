package com.ebay.ironbank.legacy;

import com.ebay.ironbank.controllers.ProductValidator;
import com.ebay.ironbank.model.Product;
import com.ebay.ironbankrulesstarter.Singleton;

import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
@Singleton
public class NameValidator implements ProductValidator {
    @Override
    public Optional<String> validate(Product product) {
        if (product.getName().length() < 4) {
            return Optional.of("name ius too short");
        }
        return Optional.empty();
    }
}
