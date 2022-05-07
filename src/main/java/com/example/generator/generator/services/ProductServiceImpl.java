package com.example.generator.generator.services;

import com.example.generator.generator.entity.EmployeeEntity;
import com.example.generator.generator.entity.ProductEntity;
import com.example.generator.generator.model.Employee;
import com.example.generator.generator.model.Product;
import com.example.generator.generator.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(product, productEntity);

        productRepository.save(productEntity);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities
                = productRepository.findAll();
        List<Product> products = productEntities
                .stream()
                .map(prod -> new Product(
                        prod.getId(),
                        prod.getUrl(),
                        prod.getName(),
                        prod.getAmount()
                ))
                .collect(Collectors.toList());
        return products;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        ProductEntity product = productRepository.findById(id).get();
        productRepository.delete(product);
        return true;
    }

    @Override
    public Product getProductById(Long id) {
        ProductEntity productEntity
                = productRepository.findById(id).get();
        Product product = new Product();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        ProductEntity productEntity
                = productRepository.findById(id).get();
        productEntity.setUrl(product.getUrl());
        productEntity.setName(product.getName());
        productEntity.setAmount(product.getAmount());

        productRepository.save(productEntity);
        return product;
    }
}
