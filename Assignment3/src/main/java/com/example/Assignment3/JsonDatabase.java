package com.example.Assignment3;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JsonDatabase {

    private static final String FILE_PATH = "C:\\Users\\hagar\\Desktop\\Assignment3\\Assignment3\\src\\main\\resources\\employees.json";
    private static final Gson gson = new Gson();

    private List<Employee> employees;

    public JsonDatabase() {
        this.employees = readEmployeesFromFile();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee newEmployee) {

        employees.add(newEmployee);
        writeEmployeesToFile(employees);
    }

    public List<Employee> searchEmployees(String searchTerm) {
        List<Employee> searchResult = new ArrayList<>();

        for (Employee employee : employees) {
            if (String.valueOf(employee.getEmployeeID()).equals(searchTerm) ||
                    employee.getDesignation().equalsIgnoreCase(searchTerm)) {
                searchResult.add(employee);
            }
        }

        return searchResult;
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getEmployeeID() == id);
        writeEmployeesToFile(employees);
    }

    public String updateEmployee(int id, String newDesignation) {
        for (Employee employee : employees) {
            if (employee.getEmployeeID() == id) {
                employee.setDesignation(newDesignation);
                writeEmployeesToFile(employees);
                return "Employee updated successfully.";
            }
        }
        return "Employee not found.";
    }

    public String getJavaExperts() {
        List<String> result = employees.stream()
                .filter(employee -> employee.getKnownLanguages().stream()
                        .anyMatch(language -> "Java".equals(language.getLanguageName()) && language.getScoreOutof100() > 50))
                .sorted(Comparator.comparingInt(employee -> getJavaScore(employee, "Java")))
                .map(employee -> String.format("%s %s - %s<br>", employee.getFirstName(), employee.getLastName(), employee.getDesignation()))
                .collect(Collectors.toList());

        return String.join(", ", result);
    }
    private int getJavaScore(Employee employee, String languageName) {
        return employee.getKnownLanguages().stream()
                .filter(language -> languageName.equals(language.getLanguageName()))
                .findFirst()
                .map(Language::getScoreOutof100)
                .orElse(0);
    }
    

    private List<Employee> readEmployeesFromFile() {
        try (FileReader fileReader = new FileReader(FILE_PATH)) {
            Type listType = new com.google.gson.reflect.TypeToken<List<Employee>>(){}.getType();
            return gson.fromJson(fileReader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeEmployeesToFile(List<Employee> employees) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            gson.toJson(employees, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

