package org.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class indexController {

    @RequestMapping("/")
    public String index(HttpServletRequest httpServletRequest){
        String sessionId = httpServletRequest.getSession().getId();
        return sessionId;
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }
}
