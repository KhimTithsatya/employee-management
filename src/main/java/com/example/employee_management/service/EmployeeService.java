package com.example.employee_management.service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.model.EmployeeStatus;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

   
    // GET ALL EMPLOYEES

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


  
    // GET EMPLOYEE BY ID

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id)
                );
    }


    // GET EMPLOYEE BY CODE

    public Employee getEmployeeByCode(String employeeCode) {

        return employeeRepository.findByEmployeeCode(employeeCode)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found with code: " + employeeCode
                        )
                );
    }


    // GET EMPLOYEE BY EMAIL

    public Employee getEmployeeByEmail(String email) {

        return employeeRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found with email: " + email
                        )
                );
    }

    // SEARCH BY NAME
   
    public List<Employee> searchByName(String name) {

        return employeeRepository.findByNameContainingIgnoreCase(name);
    }


    
    // FILTER BY DEPARTMENT

    public List<Employee> getEmployeesByDepartment(String department) {

        return employeeRepository.findByDepartmentIgnoreCase(department);
    }



    // FILTER BY STATUS
   
    public List<Employee> getEmployeesByStatus(EmployeeStatus status) {

        return employeeRepository.findByStatus(status);
    }


 
    // CREATE EMPLOYEE
    
    public Employee createEmployee(Employee employee) {

        // Check duplicate employee code
        if (employeeRepository
                .findByEmployeeCode(employee.getEmployeeCode())
                .isPresent()) {

            throw new RuntimeException(
                    "Employee code already exists: "
                            + employee.getEmployeeCode()
            );
        }

        // Check duplicate email
        if (employeeRepository
                .findByEmail(employee.getEmail())
                .isPresent()) {

            throw new RuntimeException(
                    "Email already exists: "
                            + employee.getEmail()
            );
        }

        // Set default status
        if (employee.getStatus() == null) {
            employee.setStatus(EmployeeStatus.ACTIVE);
        }

        return employeeRepository.save(employee);
    }



    // UPDATE EMPLOYEE

    public Employee updateEmployee(Long id, Employee employeeDetails) {

        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setName(employeeDetails.getName());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        existingEmployee.setPosition(employeeDetails.getPosition());
        existingEmployee.setDepartment(employeeDetails.getDepartment());
        existingEmployee.setHireDate(employeeDetails.getHireDate());
        existingEmployee.setSalary(employeeDetails.getSalary());
        existingEmployee.setStatus(employeeDetails.getStatus());

        return employeeRepository.save(existingEmployee);
    }


    // DELETE EMPLOYEE

    public void deleteEmployee(Long id) {

        Employee employee = getEmployeeById(id);

        employeeRepository.delete(employee);
    }
}