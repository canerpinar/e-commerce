package org.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.web.entity.Person;
import org.web.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = userService.findUserByUsername(s);
        if(person == null){
            throw new UsernameNotFoundException(person.getUsername() + " not found");
        }
        return new User(person.getUsername(),person.getPassword(),new ArrayList<>());
    }
}
