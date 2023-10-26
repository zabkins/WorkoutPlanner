package com.zarczynski.controller;


import com.zarczynski.entity.WorkoutPlan;
import com.zarczynski.repository.WorkoutPlanRepository;
import com.zarczynski.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    private final HomeService service;

    public HomeController(HomeService service) {
        this.service = service;
    }

    @RequestMapping("/home")
    public String hello(Model model){
        Optional<WorkoutPlan> activeWorkoutPlanOptional = service.getActivePlan();
        WorkoutPlan activeWorkoutPlan = activeWorkoutPlanOptional.orElse(null);
        model.addAttribute("activeWorkoutPlan",activeWorkoutPlan);
        return "/index";
    }

    @RequestMapping("/home/active")
    public String showActiveWorkoutPlan(Model model){
        Optional<WorkoutPlan> activeWorkoutPlanOptional = service.getActivePlan();
        WorkoutPlan activeWorkoutPlan = activeWorkoutPlanOptional.orElse(null);
        model.addAttribute("activeWorkoutPlan",activeWorkoutPlan);
        return "/workoutPlan/viewPlan";
    }

    @RequestMapping("/home/active/edit")
    public String forwardToEditingActivePlan(){
        Optional<WorkoutPlan> activeWorkoutPlanOptional = service.getActivePlan();
        WorkoutPlan activeWorkoutPlan = activeWorkoutPlanOptional.orElse(null);
        if(activeWorkoutPlan == null){
            return "/workoutPlan/viewPlan";
        }
        return String.format("redirect:/plan/edit/%d",activeWorkoutPlan.getId());
    }

    @RequestMapping("/home/list")
    public String showAllPlans(Model model){
        List<WorkoutPlan> allPlans = service.getAllPlans();
        model.addAttribute("allPlans",allPlans);
        return "/workoutPlan/list";
    }

}
