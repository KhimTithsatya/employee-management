package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.model.EmployeeStatus;
import com.example.employee_management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

       // GET ALL EMPLOYEES

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }



    // GET EMPLOYEE BY ID

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }


    // GET EMPLOYEE BY CODE

    @GetMapping("/code/{employeeCode}")
    public Employee getEmployeeByCode(
            @PathVariable String employeeCode) {

        return employeeService.getEmployeeByCode(employeeCode);
    }


    // GET EMPLOYEE BY EMAIL

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(
            @PathVariable String email) {

        return employeeService.getEmployeeByEmail(email);
    }


    // =========================
    // SEARCH BY NAME
    // =========================

    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam String name) {

        return employeeService.searchByName(name);
    }



    // FILTER BY DEPARTMENT

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(
            @PathVariable String department) {

        return employeeService.getEmployeesByDepartment(department);
    }



    // FILTER BY STATUS

    @GetMapping("/status/{status}")
    public List<Employee> getEmployeesByStatus(
            @PathVariable EmployeeStatus status) {

        return employeeService.getEmployeesByStatus(status);
    }


    // CREATE EMPLOYEE

    @PostMapping
    public Employee createEmployee(
            @RequestBody Employee employee) {

        return employeeService.createEmployee(employee);
    }


    // UPDATE EMPLOYEE

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }


    // DELETE EMPLOYEE

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);
    }
}