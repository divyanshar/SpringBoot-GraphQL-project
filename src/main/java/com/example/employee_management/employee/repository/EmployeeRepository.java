package com.example.employee_management.employee.repository;

import com.example.employee_management.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    boolean existsByEmail(String email);

}