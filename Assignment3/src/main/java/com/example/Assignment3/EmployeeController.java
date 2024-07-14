package com.example.Assignment3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee newEmployee) {
        employeeService.addEmployee(newEmployee);
        return "Employee added successfully.";
    }

    /*@GetMapping("/search")
    public List<Employee> searchEmployee(@RequestParam String searchTerm) {
        return employeeService.searchEmployees(searchTerm);
    }*/
    
    @GetMapping("/search")
    public ResponseEntity<String> searchEmployee(@RequestParam String searchTerm) {
    	List<Employee> searchResult = employeeService.searchEmployees(searchTerm);

        if (!searchResult.isEmpty()) {
            StringBuilder resultText = new StringBuilder("Search Result:<br>");
            for (Employee employee : searchResult) {
                resultText.append(String.format(" %s %s - %s<br>", employee.getFirstName(), employee.getLastName(), employee.getDesignation()));
                // You can include additional details as needed
            }

            return ResponseEntity.ok(resultText.toString());
        } else {
            return ResponseEntity.ok("No matching employees found.");
        }
    }

    

    @DeleteMapping("delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully.";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody String newDesignation) {
        return employeeService.updateEmployee(id, newDesignation);
    }

    @GetMapping("/javaExperts")
    public String getJavaExperts() {
        return employeeService.getJavaExperts();
    }
}
