package com.spring.core.Assigment.JavaBased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.core.Assigment.JavaBased")
public class config {

    @Bean
    public DataSource mysqlDataSource(){
        return new MySQLDB();
    }

    @Bean
    public DataSource postgresDataSource(){
        return new PostgresDB();
    }

    @Bean
    public EmailService emailService(){
        return new EmailService(mysqlDataSource());
    }
}
