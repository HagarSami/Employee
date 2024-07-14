package com.example.Assignment3;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final JsonDatabase jsonDatabase;

    public EmployeeRepository(JsonDatabase jsonDatabase) {
        this.jsonDatabase = jsonDatabase;
    }

    public List<Employee> getAllEmployees() {
        return jsonDatabase.getEmployees();
    }

    public void addEmployee(Employee newEmployee) {
        jsonDatabase.addEmployee(newEmployee);
    }

    public List<Employee> searchEmployees(String searchTerm) {
        return jsonDatabase.searchEmployees(searchTerm);
    }

    public void deleteEmployee(int id) {
        jsonDatabase.deleteEmployee(id);
    }

    public String updateEmployee(int id, String newDesignation) {
        return jsonDatabase.updateEmployee(id, newDesignation);
    }

    public String getJavaExperts() {
        return jsonDatabase.getJavaExperts();
    }
}
