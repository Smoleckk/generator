package com.example.generator.generator.services;

import com.example.generator.generator.entity.EmployeeEntity;
import com.example.generator.generator.entity.SalaryEntity;
import com.example.generator.generator.model.Employee;
import com.example.generator.generator.model.Salary;
import com.example.generator.generator.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService{

    private SalaryRepository salaryRepository;

    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public List<Salary> getAllSalary() {
            List<SalaryEntity> salaryEntities
                    = salaryRepository.findAll();
            List<Salary> salaries = salaryEntities
                    .stream()
                    .map(sal -> new Salary(
                            sal.getId(),
                            sal.getSalary(),
                            sal.getAmount(),
                            sal.getPrice(),
                            sal.getSum()
                           ))
                    .collect(Collectors.toList());
            return salaries;
        }

    @Override
    public boolean deleteEmployee(Long id) {
            SalaryEntity employee = salaryRepository.findById(id).get();
        System.out.println(employee);
            if(employee.equals(null)){

            }else {
                salaryRepository.delete(employee);
            }
            return true;
    }

}
