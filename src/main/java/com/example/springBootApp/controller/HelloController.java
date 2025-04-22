package com.example.springBootApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// ctrl+alt+O to remove not used imports
//@Controller
@RestController
public class HelloController {
//    @GetMapping("/")
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String helloWorld(){
        return "Welcome to the Website";
    }
}
