package com.spring.core.Assigment.JavaBased;
public class PostgresDB implements DataSource {
    @Override
    public String[] getEmails() {
        String[] emails = {"x@gmail.com","y@gmail.com","z@gmail.com"};
        return emails;
    }
}
