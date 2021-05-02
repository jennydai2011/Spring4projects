package com.jdai.SpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginDemoController {
    @PostMapping("/login")
    public String login(){
        return "login ok";
    }
    @GetMapping("/")
    public String all(){
        return "All";
    }

    @GetMapping("/level1/p1")
    public String level1(){
        return "level1";
    }

    @GetMapping("/level1/p2")
    public String level2(){
        return "level2";
    }

    @GetMapping("/level3/p3")
    public String level3(){
        return "level3";
    }
}
