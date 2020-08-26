package com.ebay.ironbank.controllers;

import com.ebay.ironbank.model.Product;
import com.ebay.ironbankrulesstarter.Legacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
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

    @Autowired
    @Legacy
    private List<ProductValidator> legacyValidators;


    @PostConstruct
    public void init() {
        System.out.println();
    }

    @PostMapping("/product/validate/legacy")
    public String validateProductlegacy(@RequestBody Product product) {
        return legacyValidators.stream().map(productValidator -> productValidator.validate(product))
                .flatMap(Optional::stream).reduce((s, s2) -> s + ", " + s2).orElse("no violations");
    }

    @PostMapping("/product/validate/all")
    public String validateProduct(@RequestBody Product product) {
        return productValidators.stream().map(productValidator -> productValidator.validate(product))
                .flatMap(Optional::stream).reduce((s, s2) -> s + ", " + s2).orElse("no violations");
    }
}
