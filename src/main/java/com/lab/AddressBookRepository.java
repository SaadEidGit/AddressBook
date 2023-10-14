package com.lab;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Integer>{
    AddressBook findById(int id);
}
