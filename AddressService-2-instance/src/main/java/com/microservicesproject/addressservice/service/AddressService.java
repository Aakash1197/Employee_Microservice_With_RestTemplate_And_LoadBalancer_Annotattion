package com.microservicesproject.addressservice.service;

import com.microservicesproject.addressservice.DTO.AddressDTO;

public interface AddressService {
    AddressDTO getAddressByEmployeeId(int employeeId);
}
