package com.ebay.ironbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

/**
 * @author Evgeny Borisov
 */
@RestController
public class BeanRegistryController {

    @Autowired
    private CustomClassLoader ccl;



    @Autowired
    private GenericApplicationContext context;

    @PostMapping("/regBean")
    public String regBean(@RequestBody BeanMetaData beanMetaData) throws ClassNotFoundException {
        Class<?> beanClass = ccl.findClass(beanMetaData.getClassName());

        var registry = (BeanDefinitionRegistry) context.getBeanFactory();
        GenericBeanDefinition myBeanDefinition = new GenericBeanDefinition();
        myBeanDefinition.setBeanClass(beanClass);
        myBeanDefinition.setScope(SCOPE_SINGLETON);
        registry.registerBeanDefinition(beanMetaData.getBeanName(), myBeanDefinition);
        context.getBean(beanMetaData.getBeanName());
        return "registered";

    }
}
