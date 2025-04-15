package com.microservicesproject.addressservice.entity;

import jakarta.persistence.*;




@Entity
@Table(name = "address", schema = "seleniumexpress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lane1;
    private String lane2;
    private String state;
    private String zip;
//    @Column(name = "employee_id")
//    private int employee_id;


   /* @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", unique = true)
    private Employee employee;*/





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLane1() {
        return lane1;
    }

    public void setLane1(String lane1) {
        this.lane1 = lane1;
    }

    public String getLane2() {
        return lane2;
    }

    public void setLane2(String lane2) {
        this.lane2 = lane2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


}
