package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @PostMapping("/createAddressBook")
    public AddressBook createAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @GetMapping("/addressBook")
    public AddressBook getAddressBook(@RequestParam(name="addressBookId") int id){
        return this.addressBookRepository.findById(id);
    }

}
