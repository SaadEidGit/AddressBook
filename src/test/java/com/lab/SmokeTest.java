package com.lab;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    AddressBookController addressBookController;

    @Autowired
    BuddyInfoController buddyInfoController;

    @Test
    public void contextLoads() {
        assertThat(addressBookController).isNotNull();
        assertThat(buddyInfoController).isNotNull();
    }

}
