package com.zarczynski.controllers;

import com.zarczynski.entities.WorkoutPlan;
import com.zarczynski.repositories.WorkoutPlanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/plan")
public class WorkoutPlanController {

    private final WorkoutPlanRepository workoutPlanRepository;

    public WorkoutPlanController(WorkoutPlanRepository workoutPlanRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        WorkoutPlan workoutPlan = new WorkoutPlan();
        model.addAttribute("workoutPlan",workoutPlan);
        return "/workoutPlan/addPlan";
    }

    @PostMapping("/add")
    public String saveWorkoutFormAndRedirectToEdit(Model model, @Valid WorkoutPlan workoutPlan, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/workoutPlan/addPlan";
        }
//        workoutPlanRepository.setAllWorkoutPlansInactive();
//        TU COS NIE DZIALA PRZY TYM QUERY - sprawdzic blad
        workoutPlan.setActive(true);
        workoutPlanRepository.save(workoutPlan);
        model.addAttribute("workoutPlan",workoutPlan);
        return "/workoutPlan/editPlan";
    }

}
