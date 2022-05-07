package com.example.generator.generator.services;

import com.example.generator.generator.entity.EmployeeEntity;
import com.example.generator.generator.model.Employee;
import com.example.generator.generator.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        return employee;
    }

//    @Override
//    public List<Employee> getAllEmployees() {
//        return null;
//    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId(),
                        emp.getIssueData(),
                        emp.getPayDate(),
                        emp.getVat(),
                        emp.getRabat(),
                        emp.getFinalPrice(),
                        emp.getImage(),
                        emp.getSalaries()))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity
                = employeeRepository.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setSalaries(employee.getSalaries());
        employeeEntity.setIssueData(employee.getIssueData());
        employeeEntity.setPayDate(employee.getPayDate());
        employeeEntity.setVat(employee.getVat());
        employeeEntity.setRabat(employee.getRabat());
        employeeEntity.setFinalPrice(employee.getFinalPrice());
        employeeEntity.setImage(employee.getImage());

        employeeRepository.save(employeeEntity);
        return employee;

    }
}
