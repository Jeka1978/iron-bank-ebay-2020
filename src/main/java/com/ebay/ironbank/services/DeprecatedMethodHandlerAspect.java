package com.ebay.ironbank.services;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class DeprecatedMethodHandlerAspect {

    @PostConstruct
    public void init(){
        System.out.println("you don't need me for the test");
    }


    @Pointcut("execution(* com.ebay..*.*(..))")
    public void ebayMethods(){}

    @Before("@annotation(Deprecated) && ebayMethods()")
    public void handleDeprecated() {
        System.out.println("DEPRECATED!!!!!!!!!!!!!!!!");
    }
}
