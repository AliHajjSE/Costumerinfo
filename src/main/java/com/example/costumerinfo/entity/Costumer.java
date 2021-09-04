package com.example.costumerinfo.entity;
import lombok.Data;


import javax.persistence.*;

@Data

@Entity
@Table(name="Costumer")

public class Costumer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    public Costumer(){

    }
    public Costumer(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
