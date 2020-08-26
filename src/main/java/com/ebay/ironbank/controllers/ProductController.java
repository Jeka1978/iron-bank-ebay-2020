package com.ebay.ironbank.controllers;

import com.ebay.ironbank.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
@RestController
public class ProductController {


    //todo add additional beans from other framework (ImportBeanDefinitionRegistrar)
    @Autowired
    private List<ProductValidator> productValidators;

    @PostMapping("/product/validate")
    public String validateProduct(@RequestBody Product product) {
        return productValidators.stream().map(productValidator -> productValidator.validate(product))
                .flatMap(Optional::stream).reduce((s, s2) -> s + ", " + s2).orElse("no violations");
    }
}
