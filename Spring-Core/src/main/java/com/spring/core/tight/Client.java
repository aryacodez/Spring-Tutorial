package com.spring.core.tight;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args){
        Vehicle vehicle = new Bike();

        Traveler traveler = new Traveler(vehicle);
        traveler.start();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);

        // Fetch Spring bean (object) from Spring IOC container
        Car car = applicationContext.getBean(Car.class);
        car.move();

        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();
    }
}
