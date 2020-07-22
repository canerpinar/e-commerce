package org.web.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.web.entity.Person;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<String,Person> users = new HashMap<>();

    public UserService(){

        Person person_1 = new Person(1L,"Ali",new BCryptPasswordEncoder().encode("123"));
        Person person_2 = new Person(2L,"Oya","123");
        Person person_3 = new Person(3L,"Alis",new BCryptPasswordEncoder().encode("1234"));
        users.put(person_1.getUsername(),person_1);
        users.put(person_2.getUsername(),person_2);
        users.put(person_3.getUsername(),person_3);
    }

    public Person findUserByUsername(String username){
        return users.get(username);
    }

}
