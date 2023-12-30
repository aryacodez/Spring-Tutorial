package com.spring.core;

import com.spring.core.Annotation.config;
import com.spring.core.controller.DemoController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoClient {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);

        DemoController demoController = applicationContext.getBean(DemoController.class);
        System.out.println(demoController.hello());
    }
}
