package com.spring.core.Assigment.JavaBased;

public class MySQLDB implements DataSource {
    @Override
    public String[] getEmails() {

        String[] emails = {"a@gmail.com","b@gmail.com","c@gmail.com"};
        return emails;
    }
}
