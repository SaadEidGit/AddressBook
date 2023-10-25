package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

   /* @GetMapping("/addressBook")
    public String addressBookController(@RequestParam(name="addressBookId") int addressBookId, Model model){
        if (addressBookRepository.findById(addressBookId) == null){
            addressBookRepository.save(new AddressBook());
        }
        AddressBook addressBook = addressBookRepository.findById(addressBookId);
        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddies", addressBook.getBuddies());
        return "addressBook";
    }*/

    @GetMapping("/homepage")
    public String greetingForm(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        model.addAttribute("buddy", new BuddyInfo());
        return "homepage";
    }

    @PostMapping("/buddyAdd")
    public String buddySubmit(@ModelAttribute("buddy") BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(1);
        addressBook.addBuddyInfo(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);
        return "buddyinfo";
    }

    @PostMapping("/addressBookCreate")
    public String addressBookSubmit(Model model){
        if (addressBookRepository.findById(1) == null){
            addressBookRepository.save(new AddressBook());
        }
        AddressBook addressBook = addressBookRepository.findById(1);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }
}
