package com.jpa.SpringDataJPA.repository;

import com.jpa.SpringDataJPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
