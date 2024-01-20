package com.jpa.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "products",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit "
                )
        }
)
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_generator")
    @SequenceGenerator(name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "stock_keeping_unit",nullable = false )
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
