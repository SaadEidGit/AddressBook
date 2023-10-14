package com.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class BuddyInfoController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    private AddressBookRepository addressBookRepository;

    @PostMapping("/addBuddyInfo")
    public BuddyInfo addBuddyInfo(@RequestParam(name="addressBookId") int addressBookId, @RequestBody BuddyInfo buddyInfo){
        AddressBook addressBook = this.addressBookRepository.findById(addressBookId);
        addressBook.addBuddyInfo(buddyInfo);

        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);

        return buddyInfo;
    }

    @DeleteMapping("/removeBuddyInfo")
    public BuddyInfo removeBuddyInfo(@RequestParam(name="addressBookId") int addressBookId, @RequestParam(name="buddyInfoId") int buddyInfoId){
        AddressBook addressBook = this.addressBookRepository.findById(addressBookId);
        BuddyInfo buddyInfo = addressBook.getBuddyInfo(buddyInfoId);
        addressBook.removeBuddyInfo(buddyInfoId);

        this.buddyInfoRepository.delete(buddyInfo);
        this.addressBookRepository.save(addressBook);

        return buddyInfo;
    }

    @GetMapping("/buddyInfo")
    public BuddyInfo getBuddyInfo(@RequestParam(name="addressBookId") int addressBookId, @RequestParam(name="buddyInfoId") int buddyInfoId) {
        AddressBook addressBook = this.addressBookRepository.findById(addressBookId);
        return addressBook.getBuddyInfo(buddyInfoId);
    }
}
