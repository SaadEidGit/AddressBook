package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressBook")
    public String addressBookController(@RequestParam(name="addressBookId") int addressBookId, Model model){
        if (addressBookRepository.findById(addressBookId) == null){
            addressBookRepository.save(new AddressBook());
        }
        AddressBook addressBook = addressBookRepository.findById(addressBookId);
        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddies", addressBook.getBuddies());
        return "addressBook";
    }
}
