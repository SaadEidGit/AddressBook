package com.lab;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    @org.junit.Test
    public void createBuddyTest() {
        BuddyInfo buddy = new BuddyInfo();
        buddy.setName("buddy");
        buddy.setPhoneNumber(1234567890);
        assertEquals("buddy", buddy.getName());
        assertEquals(1234567890, buddy.getPhoneNumber());
    }
}