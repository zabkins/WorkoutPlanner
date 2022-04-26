package com.zarczynski.controllers;


import com.zarczynski.repository.MuscleGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final MuscleGroupRepository muscleGroupRepository;

    public HomeController(MuscleGroupRepository muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }

    @RequestMapping("/home")
    public String hello(){
        return "/index";

    }
}
