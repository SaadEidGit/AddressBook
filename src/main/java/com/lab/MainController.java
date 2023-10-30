package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String homePage(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        model.addAttribute("buddy", new BuddyInfo());
        return "homepage";
    }

    @PostMapping("/buddyAdd")
    public ResponseEntity<BuddyInfo> buddySubmit(@ModelAttribute("buddy") BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(1);
        addressBook.addBuddyInfo(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);

        // Return the created BuddyInfo as a JSON response
        return new ResponseEntity<>(buddyInfo, HttpStatus.OK);
    }

    @PostMapping("/addressBookCreate")
    public ResponseEntity<AddressBook> addressBookSubmit(Model model){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);

        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddy", new BuddyInfo());

        // Return the created BuddyInfo as a JSON response
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }
}
