package com.microservicesproject.addressservice.controller;

import com.microservicesproject.addressservice.DTO.AddressDTO;
import com.microservicesproject.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId){

        return new ResponseEntity<>(addressService.getAddressByEmployeeId(employeeId), HttpStatus.OK);


    }
}
