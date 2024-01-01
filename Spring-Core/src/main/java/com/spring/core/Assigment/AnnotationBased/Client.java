package com.spring.core.Assigment.AnnotationBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);
        
        EmailService emailService = applicationContext.getBean(EmailService.class);
        emailService.sendEmail();
    }
}
