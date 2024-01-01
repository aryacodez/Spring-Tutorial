package com.spring.core.Assigment.AnnotationBased;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgresDB implements DataSource{
    @Override
    public String[] getEmails() {
        String[] emails = {"x@gmail.com","y@gmail.com","z@gmail.com"};
        return emails;
    }
}
