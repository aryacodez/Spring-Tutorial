package com.spring.core.Annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //create a spring bean
@Primary
public class Car implements Vehicle {
    @Override
    public void move(){
        System.out.println("Car is moving...");
    }
}
