package com.spring.core.DI.without;

public class MessageSender {

    private SMSService smsService;
    public MessageSender(SMSService smsService){
        this.smsService=smsService;
    }

    public void sendMessage(String msg){
        this.smsService.sendMessage(msg);
    }
}
