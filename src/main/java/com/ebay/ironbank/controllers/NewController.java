package com.ebay.ironbank.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
public class NewController {

    @PostMapping("/stam")
    public String stam(@RequestBody Person person) {
        return "ok";
    }
}
