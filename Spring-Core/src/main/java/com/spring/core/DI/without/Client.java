package com.spring.core.DI.without;

public class Client {
    public static void main(String[] args){
        String msg="hello";
        SMSService smsService=  new SMSService();
        MessageSender messageSender = new MessageSender(smsService);
        messageSender.sendMessage(msg);
    }
}
