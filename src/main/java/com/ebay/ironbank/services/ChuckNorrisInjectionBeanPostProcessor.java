package com.ebay.ironbank.services;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
@Component
public class ChuckNorrisInjectionBeanPostProcessor implements BeanPostProcessor {

    private Faker faker = new Faker();
    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectChuckNorrisQuote.class)) {
                field.setAccessible(true);
                String fact = faker.chuckNorris().fact();
                field.set(bean,fact);
            }
        }


        return bean;


    }
}
