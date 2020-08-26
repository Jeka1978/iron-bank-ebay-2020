package com.ebay.ironbank.services;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Aspect
public class DeprecatedMethodHandlerAspect {


    @Pointcut("execution(* com.ebay..*.*(..))")
    public void ebayMethods(){}

    @Before("@annotation(Deprecated) && ebayMethods()")
    public void handleDeprecated() {
        System.out.println("DEPRECATED!!!!!!!!!!!!!!!!");
    }
}
