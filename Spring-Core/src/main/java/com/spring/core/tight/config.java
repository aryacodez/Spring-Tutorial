package com.spring.core.tight;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {

    //Car() method is creating the object of Car class whose
    //object creating and lifecycle is being managed by the bean
    //and storing in the spring IOC container
    @Bean
    public Vehicle car(){
        return new Car();
    }

    @Bean
    public Vehicle bike(){
        return new Bike();
    }

    @Bean
    public Traveler traveler(){
        return new Traveler(car());
    }
}
