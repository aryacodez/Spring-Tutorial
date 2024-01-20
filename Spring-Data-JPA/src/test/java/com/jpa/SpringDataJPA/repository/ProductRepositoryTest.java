package com.jpa.SpringDataJPA.repository;

import com.jpa.SpringDataJPA.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("first");
        product.setDescription("example");
        product.setSku("102PB");
        product.setPrice(new BigDecimal(1500));
        product.setActive(true);
        product.setImageUrl("pn.jpg");

        //save product
        Product saved = productRepository.save(product);
        //display
        System.out.println(saved.getId());
        System.out.println(saved.toString());

    }

    @Test
    void updateUsingSaveMethod(){
        //retrieve entity by id
        Long id =1L;
        Product product = productRepository.findById(id).get();
        //update info
        product.setName("Updated Product");
        product.setDescription("Updated example");

        productRepository.save(product);
    }

    @Test
    void findByIdMethod(){
        Long id=1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){
        Product product = new Product();
        product.setName("second");
        product.setDescription("example");
        product.setSku("103PB");
        product.setPrice(new BigDecimal(1600));
        product.setActive(true);
        product.setImageUrl("pn.jpg");

        Product product2 = new Product();
        product2.setName("third");
        product2.setDescription("example");
        product2.setSku("104PB");
        product2.setPrice(new BigDecimal(1600));
        product2.setActive(true);
        product2.setImageUrl("pn.jpg");

        productRepository.saveAll(List.of(product,product2));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach((p)->{
            System.out.println(p.toString());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id=1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        //find entity by id
        Long id=2L;
        Product product = productRepository.findById(id).get();
        //delete entity
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){

        //delete all data from db
       // productRepository.deleteAll();

        //delete specific entities from db using deleteAll
        Product product = productRepository.findById(5L).get();
        Product product1 = productRepository.findById(6L).get();
        productRepository.deleteAll(List.of(product1,product));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id=1L;
        boolean res = productRepository.existsById(id);
        System.out.println(res);

        boolean res1 = productRepository.existsById(7L);
        System.out.println(res1);
    }
}