package com.example.employee_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String position;

    private String phoneNumber;

    // Default constructor
    public Employee() {
    }

    // Constructor with fields
    public Employee(String name, String position, String phoneNumber) {
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
    }

    // Overloaded constructor for backwards compatibility
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.phoneNumber = ""; 
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}