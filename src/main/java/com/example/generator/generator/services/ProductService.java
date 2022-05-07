package com.example.generator.generator.services;

import com.example.generator.generator.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product createProduct(Product product);

    boolean deleteEmployee(Long id);

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);
}
