package com.spring.core.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ioc {

    public static void main(String[] args) {

        //Creating Spring IOC Container
        //Reading the Configuration file
        //Create and Manage Spring Bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);

        //Fetch Spring bean(object) from Spring IOC container
        Car car = applicationContext.getBean(Car.class);
        car.move();

        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();
    }
}
