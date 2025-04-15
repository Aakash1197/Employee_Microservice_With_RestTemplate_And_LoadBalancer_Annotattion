package com.microservicesproject.employeeservice.service;

import com.microservicesproject.employeeservice.DTO.EmployeeDTO;

public interface EmployeeService {
    public EmployeeDTO getEmployeeById(Integer id);
}
