package com.lab;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    @org.junit.Test
    public void addBuddyInfo() {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName("buddy");
        buddy.setPhoneNumber(1234567890);

        assertEquals(0, addressBook.getNumOfBuddies());
        addressBook.addBuddyInfo(buddy);
        assertEquals(1, addressBook.getNumOfBuddies());
    }
}