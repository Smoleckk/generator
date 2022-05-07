package com.example.generator.generator.model;

import com.example.generator.generator.entity.SalaryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
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
    private List<SalaryEntity> salaries;
}
