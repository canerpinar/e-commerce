package org.web.service;


import org.springframework.stereotype.Service;
import org.web.entity.Person;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<String,Person> users = new HashMap<>();

    public UserService(){

        Person person_1 = new Person(1L,"Ali","123");
        Person person_2 = new Person(2L,"Oya","123");
        users.put(person_1.getUsername(),person_1);
        users.put(person_2.getUsername(),person_2);
    }

    public Person findUserByUsername(String username){
        return users.get(username);
    }

}
