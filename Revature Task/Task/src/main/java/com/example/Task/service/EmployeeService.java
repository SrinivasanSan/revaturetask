package com.example.Task.service;

import com.example.Task.Entity.Employee;
import com.example.Task.Exception.EmployeeNotFoundException;
import com.example.Task.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee createEmployee(@Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setAge(updatedEmployee.getAge());
            employee.setPosition(updatedEmployee.getPosition());

            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
    }


    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }

    public Page<Employee> getAllEmployees(String search, Pageable pageable) {
        if (search != null && !search.isEmpty()) {
            return employeeRepository.searchEmployees(search, pageable);
        }
        return employeeRepository.findAll(pageable);
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }

}
