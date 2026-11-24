package com.example.employee_management.employee.dto;

import jakarta.validation.constraints.*;

public record EmployeeRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email")
        String email,

        String department,

        @NotNull(message = "Salary is required")
        @PositiveOrZero(message = "Salary cannot be negative")
        Double salary

) {}