package com.spring.core.Assigment.JavaBased;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailService {

    private DataSource dataSource;

    @Autowired
    public EmailService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    void sendEmail(){
        String[] emails = dataSource.getEmails();
        for(String i:emails){
            System.out.println(i);
        }
    }
}
