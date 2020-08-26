package com.ebay.ironbank.controllers;

import com.ebay.ironbank.services.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/iron-bank/")
public class BankController {

    private final BankService bankService;


    @GetMapping("balance")
    public String getBalance() {
        return "total balance is: " + bankService.getBalance();
    }



    @GetMapping("loan")
    public String loan(@RequestParam String name, @RequestParam int amount) {
        if (bankService.loan(name, amount)) {
            return "money was transferred";
        }else {
            return "we decided not to trust you, you will not survive the winter";
        }
    }


}
