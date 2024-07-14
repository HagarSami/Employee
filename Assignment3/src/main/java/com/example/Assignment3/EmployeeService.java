package com.example.Assignment3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public void addEmployee(Employee newEmployee) {
        employeeRepository.addEmployee(newEmployee);
    }

    public List<Employee> searchEmployees(String searchTerm) {
        return employeeRepository.searchEmployees(searchTerm);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    public String updateEmployee(int id, String newDesignation) {
        return employeeRepository.updateEmployee(id, newDesignation);
    }

    public String getJavaExperts() {
        return employeeRepository.getJavaExperts();
    }
}
