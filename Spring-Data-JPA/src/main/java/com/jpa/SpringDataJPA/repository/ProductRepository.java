package com.jpa.SpringDataJPA.repository;

import com.jpa.SpringDataJPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);

    @Override
    Optional<Product> findById(Long id);


    List<Product> findByNameOrDescription(String name,String desc);

    Product findDistinctByName(String name);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal startPrice,BigDecimal endPrice);

    List<Product> findByDateCreatedBetween(LocalDateTime start, LocalDateTime end);

    List<Product> findByNameIn(List<String> names);

    List<Product> findFirstByOrderByNameAsc();

    List<Product> findTop3ByOrderByNameDesc();


}
