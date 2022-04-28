package com.zarczynski.controllers;

import com.zarczynski.entities.WorkoutPlan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plan")
public class WorkoutPlanController {

    @GetMapping("/add")
    public String showAddForm(Model model){
        WorkoutPlan workoutPlan = new WorkoutPlan();
        model.addAttribute("workoutPlan");
        return "/workoutPlan/add";
    }

}
