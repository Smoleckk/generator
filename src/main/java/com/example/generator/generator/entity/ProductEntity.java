package com.example.generator.generator.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    private String name;
    private String amount;
}
