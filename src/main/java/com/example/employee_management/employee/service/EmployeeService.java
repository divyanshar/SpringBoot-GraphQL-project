package com.example.employee_management.employee.service;

import com.example.employee_management.employee.dto.*;
import com.example.employee_management.employee.entity.Employee;
import com.example.employee_management.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponse createEmployee(EmployeeRequest request) {

        if (repository.existsByEmail(request.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
        }

        Employee employee = new Employee(
                request.name(),
                request.email(),
                request.department(),
                request.salary()
        );

        Employee saved = repository.save(employee);

        return mapToResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAllEmployees() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public EmployeeResponse getEmployeeById(UUID id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found"
                ));

        return mapToResponse(employee);
    }

    public EmployeeResponse updateEmployee(
            UUID id,
            EmployeeRequest request
    ) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employee not found"
                ));

        employee.update(
                request.name(),
                request.department(),
                request.salary()
        );

        return mapToResponse(repository.save(employee));
    }

    public void deleteEmployee(UUID id) {

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Employee not found"
            );
        }

        repository.deleteById(id);
    }

    private EmployeeResponse mapToResponse(Employee employee) {

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}