package com.example.generator.generator.repository;

import com.example.generator.generator.entity.ProductEntity;
import com.example.generator.generator.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
