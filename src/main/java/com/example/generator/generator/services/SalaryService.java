package com.example.generator.generator.services;

import com.example.generator.generator.model.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> getAllSalary();

    boolean deleteEmployee(Long id);
}
