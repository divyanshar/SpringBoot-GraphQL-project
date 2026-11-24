package com.example.employee_management.employee.dto;

import java.util.UUID;

public record EmployeeResponse(
        UUID id,
        String name,
        String email,
        String department,
        Double salary
) {}