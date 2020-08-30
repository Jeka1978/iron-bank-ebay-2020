package com.ebay.ironbank;

import com.ebay.ironbankrulesstarter.IronBankExceptionHandlingAspectConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@ImportResource("classpath:aop.xml")
@SpringBootApplication(exclude = {IronBankExceptionHandlingAspectConf.class})
//@EnableAutoConfiguration(exclude ={IronBankExceptionHandlingAspectConf.class} )
//@EnableScheduling
public class IronBankApplication {


    public static void main(String[] args) {


        System.setProperty("java.awt.headless", "false");

        ConfigurableApplicationContext context = SpringApplication.run(IronBankApplication.class, args);


        System.out.println();

    }

}
//@SpringBootApplication(exclude = {IronBankExceptionHandlingAspectConf.class})
