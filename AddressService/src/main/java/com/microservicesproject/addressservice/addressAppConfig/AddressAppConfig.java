package com.microservicesproject.addressservice.addressAppConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AddressAppConfig {
    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
