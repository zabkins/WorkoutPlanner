package com.zarczynski.controllers;


import com.zarczynski.entities.WorkoutPlan;
import com.zarczynski.repositories.WorkoutPlanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    private final WorkoutPlanRepository workoutPlanRepository;

    public HomeController(WorkoutPlanRepository workoutPlanRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
    }

    @RequestMapping("/home")
    public String hello(Model model){
        Optional<WorkoutPlan> activeWorkoutPlanOptional = workoutPlanRepository.getActiveWorkoutPlan();
        WorkoutPlan activeWorkoutPlan = activeWorkoutPlanOptional.orElse(null);
        model.addAttribute("activeWorkoutPlan",activeWorkoutPlan);
        return "/index";
    }
}
