package com.spring.core.DI.with;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService{

    @Override
    public void sendMessage(String msg) {
        System.out.println(msg);
    }
}
