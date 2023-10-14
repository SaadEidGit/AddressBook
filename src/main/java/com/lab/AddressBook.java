package com.lab;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * The AddressBook class represents the object in which it stores the BuddyInfo object
 */
@Component
@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    public AddressBook(){
        this.buddies = new ArrayList<>();
    }

    public void addBuddyInfo(BuddyInfo buddy){
        this.buddies.add(buddy);
    }

    public int getNumOfBuddies() {
        return this.buddies.size();
    }


    public List<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuddyInfo getBuddyInfo(int buddyInfoId) {
        return this.buddies.get(buddyInfoId - 1);
    }

    public void removeBuddyInfo(int buddyInfoId) {
        this.buddies.remove(buddyInfoId - 1);
    }

}
