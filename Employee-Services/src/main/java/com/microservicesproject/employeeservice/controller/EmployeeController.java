package com.microservicesproject.employeeservice.controller;

import com.microservicesproject.employeeservice.DTO.EmployeeDTO;
import com.microservicesproject.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity< EmployeeDTO> getEmployeeDetails(@PathVariable("id") int id){
        EmployeeDTO EmployeeDTO  =employeeService.getEmployeeById(id);
      return  new ResponseEntity<>( EmployeeDTO, HttpStatus.OK);
    }
}
