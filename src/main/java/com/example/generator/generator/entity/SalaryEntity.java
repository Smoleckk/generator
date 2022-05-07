package com.example.generator.generator.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@Table(name = "salary")
public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String salary;
    private String amount;
    private String price;
    private String sum;

    @ManyToOne
    @JsonIgnore
    private EmployeeEntity employeeEntity;
}
