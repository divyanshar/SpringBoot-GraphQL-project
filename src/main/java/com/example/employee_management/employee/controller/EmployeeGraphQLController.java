package com.example.employee_management.employee.controller;
import com.example.employee_management.employee.dto.*;
import com.example.employee_management.employee.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class EmployeeGraphQLController {

    private final EmployeeService employeeService;

    public EmployeeGraphQLController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping
    public List<EmployeeResponse> employees() {
        return employeeService.getAllEmployees();
    }

    @QueryMapping
    public EmployeeResponse employee(@Argument String id) {
        return employeeService.getEmployeeById(UUID.fromString(id));
    }

    @MutationMapping
    public EmployeeResponse createEmployee(
            @Argument EmployeeRequest input
    ) {
        return employeeService.createEmployee(input);
    }
}