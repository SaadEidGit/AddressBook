package com.lab;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BuddyInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String buddy1 = "{\"name\": \"buddy1\", \"phoneNumber\": 111111, \"address\": \"address1\"}";
    private String buddy2 = "{\"name\": \"buddy2\", \"phoneNumber\": 222222, \"address\": \"address2\"}";

    @Test
    public void creatingAndDeletingBuddyInfo() throws Exception {
        //Creating the Addressbook to add the buddyinfo to
        this.mockMvc.perform(post("/createAddressBook")).andExpect(status().isOk());
        this.mockMvc.perform(get("/addressBook?addressBookId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("AddressBook ID: 1")));

        //Adding a BuddyInfo to AddressBook
        this.mockMvc.perform(post("/addBuddyInfo?addressBookId=1")
                .contentType("application/json") // Set the appropriate content type
                .content(buddy1))
                .andExpect(status().isOk());

        this.mockMvc.perform(post("/addBuddyInfo?addressBookId=1")
                .contentType("application/json") // Set the appropriate content type
                .content(buddy2))
                .andExpect(status().isOk());

        //Get BuddyInfos from AddressBook
        this.mockMvc.perform(get("/buddyInfo?addressBookId=1&buddyInfoId=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"name\":\"buddy1\",\"phoneNumber\":111111,\"address\":\"address1\",\"id\":1}")));

        this.mockMvc.perform(get("/buddyInfo?addressBookId=1&buddyInfoId=2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"name\":\"buddy2\",\"phoneNumber\":222222,\"address\":\"address2\",\"id\":2}")));

        // Deleting BuddyInfo 2
        this.mockMvc.perform(delete("/removeBuddyInfo?addressBookId=1&buddyInfoId=2"))
                .andExpect(status().isOk());

        //Get BuddyInfos from AddressBook
        this.mockMvc.perform(get("/addressBook?addressBookId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(not(containsString("{\"name\":\"buddy2\",\"phoneNumber\":222222,\"address\":\"address1\",\"id\":2}"))));
    }
}