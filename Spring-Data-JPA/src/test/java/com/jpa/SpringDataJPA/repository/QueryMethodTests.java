package com.jpa.SpringDataJPA.repository;

import com.jpa.SpringDataJPA.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
public class QueryMethodTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("second");
        System.out.println(product.getId());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
    }

    @Test
    void findByNameOrDescMethod(){
        List<Product> productList = productRepository.findByNameOrDescription("second","example");
        productList.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("second");
        System.out.println(product.getId());
    }

    @Test
    void priceGreaterThan(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(1000));
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void priceLessThan(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(1000));
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void containingMethod(){
        List<Product> products = productRepository.findByNameContaining("second");
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void  likeMethod(){
        List<Product> products = productRepository.findByNameLike("third");
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void priceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(1200),new BigDecimal(1700));
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void dateBetween(){
        LocalDateTime start = LocalDateTime.of(2024,01,22,20,49);
        LocalDateTime end = LocalDateTime.of(2024,01,22,20,49);
        List<Product> products = productRepository.findByDateCreatedBetween(start,end);
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void namesInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("second","third"));
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void findFirstMethod(){
        List<Product> products = productRepository.findFirstByOrderByNameAsc();
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }

    @Test
    void findTopMethod(){
        List<Product> products = productRepository.findTop3ByOrderByNameDesc();
        products.forEach((p)->{
            System.out.println(p.getId());
        });
    }
}
