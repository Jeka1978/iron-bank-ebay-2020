package com.ebay.ironbank.controllers;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Evgeny Borisov
 */
@Component
public class CustomClassLoader extends ClassLoader{
    @Override
    @SneakyThrows
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        String fileName = "target/classes/"+className.replace('.', File.separatorChar) + ".class";
        byte[] b =  Files.newInputStream(Path.of(fileName)).readAllBytes();
        return defineClass(className, b, 0, b.length);


    }
}
