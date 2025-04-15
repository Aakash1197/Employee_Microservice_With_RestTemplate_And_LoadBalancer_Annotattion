package com.microservicesproject.addressservice.entity;


import jakarta.persistence.*;

import java.util.List;

@Table
@Entity(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private String name;

    private String email;
    @Column(name = "bloodgroup")
    private String bloodgroup;
//    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Address address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}
