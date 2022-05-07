package com.example.generator.generator.controller;

import com.example.generator.generator.model.Salary;
import com.example.generator.generator.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SalaryController {

    private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }


    @GetMapping("/salaries")
    public List<Salary> getAllSalary() {
        return  salaryService.getAllSalary();
    }

    @DeleteMapping("/salaries/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteSalaries(@PathVariable Long id) {
        boolean deleted = false;
        deleted = salaryService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }
}
