package com.microservicesproject.addressservice.repository;

import com.microservicesproject.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {

    @Query(nativeQuery = true,value = "SELECT ea.id, ea.lane1, ea.lane2, ea.state, ea.zip FROM employee e JOIN Address  ea ON e.id = ea.id WHERE ea.employee_id= :employee_id")
    Address findAddressByEmployeeId(@Param("employee_id") int employee_id);

}
