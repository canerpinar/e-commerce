package org.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web.entity.Person;
import org.web.service.JwtTokenUtil;
import org.web.service.JwtUserDetailService;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.Collection;

@RestController
public class indexController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping("/")
    public String index(HttpServletRequest httpServletRequest){
        String sessionId = httpServletRequest.getSession().getId();
        return sessionId;
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticate(@RequestBody Person person){
        System.out.println(person.getUsername());
        System.out.println(person.getPassword());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(person.getUsername(),person.getPassword()));
        final UserDetails userDetails = jwtUserDetailService.loadUserByUsername(person.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }
}
