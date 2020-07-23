package org.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.web.entity.User;

import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    @ResponseBody
    public void signin(@RequestParam Map<String,String> params){
        System.out.println(params.get("username"));
        //return "signin";
    }
}
