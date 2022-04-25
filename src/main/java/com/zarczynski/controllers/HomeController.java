package com.zarczynski.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {


    @RequestMapping("/hello")
    public String hello(){
        return "/hello";
    }
}
