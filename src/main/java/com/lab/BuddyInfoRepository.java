package com.lab;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    BuddyInfo findById(int id);
    BuddyInfo findByName(String name);
    BuddyInfo removeById(int id);
}
