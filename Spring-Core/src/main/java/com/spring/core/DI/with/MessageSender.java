package com.spring.core.DI.with;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

//    Field  Based onjection
//    @Autowired
//    @Qualifier("SMSService")
//    private MessageService messageService;

    private MessageService messageService;

    @Autowired
    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
        System.out.println("Constructor Injection");
    }

    //Setter based injection
//    @Autowired
//    public void setMessageService(@Qualifier("SMSService") MessageService messageService) {
//        this.messageService = messageService;
//        System.out.println("Setter-based Injection");
//    }

    public void sendMessage(String msg){
        this.messageService.sendMessage(msg);
    }
}
