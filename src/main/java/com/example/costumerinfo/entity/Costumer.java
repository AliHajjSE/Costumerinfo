package com.example.costumerinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Costumer")

public class Costumer {
    @Id
    @GeneratedValue
     private int id;
    private String name;
    private int phoneNumber;
    private String address;

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
