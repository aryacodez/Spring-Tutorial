package com.spring.core.DI.with;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args){
        String msg="hello sms";
        //SMSService smsService=  new SMSService();
        //EmailService emailService = new EmailService();
//        MessageSender messageSender = new MessageSender();
//        messageSender.sendMessage(msg);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);
        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        messageSender.sendMessage(msg);
    }
}
