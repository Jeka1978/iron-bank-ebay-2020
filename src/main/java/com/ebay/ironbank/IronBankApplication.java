package com.ebay.ironbank;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource("classpath:aop.xml")
public class IronBankApplication {


    public static void main(String[] args) {


        System.setProperty("java.awt.headless", "false");

        ConfigurableApplicationContext context = SpringApplication.run(IronBankApplication.class, args);


        System.out.println();

    }

}
