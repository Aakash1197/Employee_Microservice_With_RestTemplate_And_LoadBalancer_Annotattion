package com.microservicesproject.employeeservice.service;

import com.microservicesproject.employeeservice.DTO.AddressDTO;
import com.microservicesproject.employeeservice.DTO.EmployeeDTO;
import com.microservicesproject.employeeservice.enity.Employee;
import com.microservicesproject.employeeservice.repository.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WebClient webClient;
      @Autowired
      private RestTemplate restTemplate;
    //without load balancer
 /*     @Autowired
      private DiscoveryClient discoveryClient;*/
    //with load balancer
      @Autowired
      private LoadBalancerClient loadBalancerClient;

   /* @Value("${addressservice.base.url}")
    private String addressBaseUrl;*/

 /*   public EmployeeServiceImpl(@Value("${addressservice.base.url}")  String addressBaseUrl,RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                             .rootUri(addressBaseUrl)
                              .build();
    }*/

    public EmployeeDTO getEmployeeById(Integer id){
        AddressDTO addressDTO;
        //get employee dto
        Employee employee= employeeRepo.findById(id).get();
        //get address dto using by rest call (Rest Template)
        addressDTO=this.getAddressByRestCall(id);
        //addressDTO= callAddressServiceUsingWithWebClient(id);

        EmployeeDTO employeeDTO=modelMapper.map(employee,EmployeeDTO.class);
        //assign that address DTO to employeDTO using setAddress()
        employeeDTO.setAddress(addressDTO);
        return employeeDTO;
    }

    private AddressDTO callAddressServiceUsingWithWebClient(Integer id) {
        return webClient
                .get()
                .uri("/address/" + id)
                .retrieve()
                .bodyToMono(AddressDTO.class)
                .block();
    }

    private  AddressDTO getAddressByRestCall(Integer id) {
        //without load balancer
       /* List< ServiceInstance> services =discoveryClient.getInstances("address-service");
        System.out.println(services.size());
        services.forEach(service->{
            System.out.println(service.getUri().toString());
        });
        ServiceInstance instance=services.get(0);
        String uriAddress=instance.getUri().toString();
        System.out.println("getting discovery client uri from eureka server :-"+uriAddress);
        return restTemplate.getForObject(uriAddress+"/address-app/api/address/{id}", AddressDTO.class, id);*/

   /*
        //with load balancer in programaticaly way
       ServiceInstance instance= loadBalancerClient.choose("address-service");
       String uri= instance.getUri().toString();
        return restTemplate.getForObject(uri+"/address-app/api/address/{id}", AddressDTO.class, id);*/

        return restTemplate.getForObject("http://ADDRESS-SERVICE/address-app/api/address/{id}", AddressDTO.class, id);


    }
}
