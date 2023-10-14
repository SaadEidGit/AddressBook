package com.lab;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * The BuddyInfo class represents the object in which it stores the name and
 * phone number information
 */
@Entity
public class BuddyInfo {
    private String name;
    private int phoneNumber;
    @Id
    @GeneratedValue
    private int id;

    public BuddyInfo(){}
    public BuddyInfo(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

}
