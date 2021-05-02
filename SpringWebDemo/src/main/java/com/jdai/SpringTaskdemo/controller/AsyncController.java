package com.jdai.SpringTaskdemo.controller;

import com.jdai.SpringTaskdemo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello();
        System.out.println(" synchronized calling of service");
        return "success";
    }
}
