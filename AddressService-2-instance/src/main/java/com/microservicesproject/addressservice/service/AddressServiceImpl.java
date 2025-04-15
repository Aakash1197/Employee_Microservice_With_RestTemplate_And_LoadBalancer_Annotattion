package com.microservicesproject.addressservice.service;

import com.microservicesproject.addressservice.DTO.AddressDTO;
import com.microservicesproject.addressservice.entity.Address;
import com.microservicesproject.addressservice.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AddressDTO getAddressByEmployeeId(int employeeId) {
        System.out.println("get address by employee id-8082"+" "+employeeId);
        Address address =addressRepo.findAddressByEmployeeId(employeeId);
        return modelMapper.map(address,AddressDTO.class);
    }
}
