package com.example.employee_management.employee.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String department;

    private Double salary;

    protected Employee() {
    }

    public Employee(
            String name,
            String email,
            String department,
            Double salary
    ) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public Double getSalary() {
        return salary;
    }

    public void update(
            String name,
            String department,
            Double salary
    ) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}