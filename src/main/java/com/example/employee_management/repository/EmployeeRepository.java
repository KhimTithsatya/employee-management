package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employee by employee code
    Optional<Employee> findByEmployeeCode(String employeeCode);

    // Find employee by email
    Optional<Employee> findByEmail(String email);

    // Search employees by name
    List<Employee> findByNameContainingIgnoreCase(String name);

    // Search employees by department
    List<Employee> findByDepartmentIgnoreCase(String department);

    // Search employees by status
    List<Employee> findByStatus(String status);
}