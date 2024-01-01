package com.spring.core.beans;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Student{
    private Address address;

    Student(Address address){
        this.address = address;
    }

    public void print(){
        System.out.println("Student class method called...");
        address.print();
    }

    public void init(){
        System.out.println("Initialization Logic");
    }

    public void destroy(){
        System.out.println("Destruction logic");
    }
}

class Address{
    public void print(){
        System.out.println("Address class method called...");
    }
}

@Configuration
class config{
    @Bean(name = "addressBean")
    public  Address address(){
        return new Address();
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Student student(){
        return new Student(address());
    }
}
public class BeanAnnotationDemo {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);
//
//        Student student = applicationContext.getBean(Student.class);
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//        for (String i : beanNames) {
//            System.out.println(i);
//        }
//        student.print();
//
//
//        //Retrieve using Bean Name
//        Address address = (Address) applicationContext.getBean("addressBean");
//        address.print();

        //To use destroy method
        try (var applicationContext = new AnnotationConfigApplicationContext(config.class)) {

            Student student = applicationContext.getBean(Student.class);
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            for (String i : beanNames) {
                System.out.println(i);
            }
            student.print();


            //Retrieve using Bean Name
            Address address = (Address) applicationContext.getBean("addressBean");
            address.print();
        }
    }
}
