package com.spring.core.DI.with;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SMSService implements MessageService{
    public void sendMessage(String msg){
        System.out.println(msg);
    }
}
