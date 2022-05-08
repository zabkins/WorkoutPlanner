package com.zarczynski.controllers;

import com.zarczynski.entities.TrainingDay;
import com.zarczynski.entities.WorkoutPlan;
import com.zarczynski.repositories.WorkoutPlanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

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
    public String saveWorkoutAddFormAndRedirectToEditForm(Model model, @Valid WorkoutPlan workoutPlan, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/workoutPlan/addPlan";
        }
        workoutPlanRepository.setAllActiveWorkoutPlansInactive();
        workoutPlan.setActive(true);
        workoutPlanRepository.save(workoutPlan);
        model.addAttribute("workoutPlanToEdit",workoutPlan);
        return "/workoutPlan/editPlan";
    }

    @GetMapping("/edit/{id}")
    public String showWorkoutEditForm(Model model, @PathVariable Long id){
        Optional<WorkoutPlan> workoutPlanToEditOpt = workoutPlanRepository.findById(id);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToEdit",workoutPlanToEdit);
        return "/workoutPlan/editPlan";
    }

    @GetMapping("/edit/name/{id}")
    public String showNameEditForm(Model model, @PathVariable Long id){
        Optional<WorkoutPlan> workoutPlanToEditOpt = workoutPlanRepository.findById(id);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToEdit",workoutPlanToEdit);
        return "/workoutPlan/editName";
    }

    @PostMapping("/edit/name")
    public String saveNameEditForm(Model model, @ModelAttribute("workoutPlanToEdit")@Valid WorkoutPlan workoutPlan, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/workoutPlan/editName";
        }
        workoutPlanRepository.save(workoutPlan);
        return String.format("redirect:/plan/edit/%d",workoutPlan.getId());
    }

    @GetMapping("/active/{id}")
    public String makePlanActiveByGivenId(@PathVariable Long id){
        workoutPlanRepository.setAllActiveWorkoutPlansInactive();
        workoutPlanRepository.setWorkoutPlanActiveById(id);
        return "redirect:/home/list";
    }

    @GetMapping("/delete/{id}")
    public String showPlanDeleteConfirmation(Model model, @PathVariable Long id){
        Optional<WorkoutPlan> workoutPlanToDeleteOpt = workoutPlanRepository.findById(id);
        WorkoutPlan workoutPlanToDelete = workoutPlanToDeleteOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToDelete",workoutPlanToDelete);
        return "/workoutPlan/confirmDelete";
    }

    @GetMapping("/delete/confirm/{id}")
    public String deleteConfirmedPlan(@PathVariable Long id){
        workoutPlanRepository.deleteWorkoutPlanTrainingDaysPlanByPlanId(id);
        workoutPlanRepository.deleteById(id);
        return "redirect:/home/list";
    }


}
