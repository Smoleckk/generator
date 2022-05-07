package com.example.generator.generator.repository;

import com.example.generator.generator.entity.SalaryEntity;
import com.example.generator.generator.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity,Long> {
}
