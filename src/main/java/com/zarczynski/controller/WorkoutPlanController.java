package com.zarczynski.controller;

import com.zarczynski.entity.WorkoutPlan;
import com.zarczynski.repository.WorkoutPlanRepository;
import com.zarczynski.service.WorkoutPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/plan")
public class WorkoutPlanController {
    
    private final WorkoutPlanService service;

    public WorkoutPlanController(WorkoutPlanService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        WorkoutPlan workoutPlan = new WorkoutPlan();
        model.addAttribute("workoutPlan",workoutPlan);
        return "/workoutPlan/addPlan";
    }

    @PostMapping("/add")
    public String saveWorkoutAddFormAndRedirectToEditForm(Model model, @Valid WorkoutPlan workoutPlan, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/workoutPlan/addPlan";
        }
        service.setAllActivePlansInactive();
        workoutPlan.setActive(true);
        service.savePlan(workoutPlan);
        model.addAttribute("workoutPlanToEdit",workoutPlan);
        return "/workoutPlan/editPlan";
    }

    @GetMapping("/edit/{id}")
    public String showWorkoutEditForm(Model model, @PathVariable Long id){
        Optional<WorkoutPlan> workoutPlanToEditOpt = service.findPlan(id);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToEdit",workoutPlanToEdit);
        return "/workoutPlan/editPlan";
    }

    @GetMapping("/edit/name/{id}")
    public String showNameEditForm(Model model, @PathVariable Long id){
        Optional<WorkoutPlan> workoutPlanToEditOpt = service.findPlan(id);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToEdit",workoutPlanToEdit);
        return "/workoutPlan/editName";
    }

    @PostMapping("/edit/name")
    public String saveNameEditForm(Model model, @ModelAttribute("workoutPlanToEdit")@Valid WorkoutPlan workoutPlan, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/workoutPlan/editName";
        }
        service.savePlan(workoutPlan);
        return String.format("redirect:/plan/edit/%d",workoutPlan.getId());
    }

    @GetMapping("/active/{id}")
    public String makePlanActiveByGivenId(@PathVariable Long id){
        service.setAllActivePlansInactive();
        service.setWorkoutPlanActive(id);
        return "redirect:/home/list";
    }

    @GetMapping("/delete/{id}")
    public String showPlanDeleteConfirmation(Model model, @PathVariable Long id){
        Optional<WorkoutPlan> workoutPlanToDeleteOpt = service.findPlan(id);
        WorkoutPlan workoutPlanToDelete = workoutPlanToDeleteOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToDelete",workoutPlanToDelete);
        return "/workoutPlan/confirmDelete";
    }

    @GetMapping("/delete/confirm/{id}")
    public String deleteConfirmedPlan(@PathVariable Long id){
        service.deletePlansTrainingDayById(id);
        service.deletePlan(id);
        return "redirect:/home/list";
    }


}
