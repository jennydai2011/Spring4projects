package com.jdai.SpringThymeleafDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//use Thymeleaf as view render, has to use @Controller but not @RestController
@Controller
public class TestController {
    @GetMapping("/main")
    public String main(Model model) {
//        model.addAttribute("message", message);
//        model.addAttribute("tasks", tasks);

        return "Test"; //view
    }
    //1. ajax call can only return void
    //2. method parameter is the data's attributes from ajax request
    @GetMapping("/testAjax")
    @ResponseBody
//    public ResponseEntity<String> testAjax(Integer id){
//        System.out.println("    controller got ajax request.....id="+ id );
//        return ResponseEntity.ok(" response body...");
//    }
    public String testAjax(Integer id){
        System.out.println("    controller got ajax request.....id="+ id );
        return " response data from server...";
    }


    @GetMapping("/toView2")
    public ModelAndView toView2(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", "root");
        mav.setViewName("view2");

        return mav;
    }
}
