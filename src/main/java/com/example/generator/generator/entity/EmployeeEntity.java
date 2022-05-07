package com.example.generator.generator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String issueData;
    private String payDate;
    private String vat;
    private String rabat;
    private String finalPrice;
    private String image;
//cascade = CascadeType.ALL,orphanRemoval = true
    @JoinColumn(name = "employees_id")
    @OneToMany(targetEntity = SalaryEntity.class,cascade = CascadeType.ALL)

    private List<SalaryEntity> salaries;
    // orphanRemoval = true
}
