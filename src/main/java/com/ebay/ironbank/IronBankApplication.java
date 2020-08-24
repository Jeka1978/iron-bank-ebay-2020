package com.ebay.ironbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ImportResource("classpath:aop.xml")
@EnableJpaRepositories(basePackages = "com.ebay.ironbank")
public class IronBankApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(IronBankApplication.class, args);


    }

}
