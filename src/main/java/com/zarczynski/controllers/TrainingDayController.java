package com.zarczynski.controllers;

import com.zarczynski.entities.TrainingDay;
import com.zarczynski.entities.WorkoutPlan;
import com.zarczynski.repositories.TrainingDayRepository;
import com.zarczynski.repositories.WorkoutPlanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/tday")
public class TrainingDayController {

    private final TrainingDayRepository trainingDayRepository;
    private final WorkoutPlanRepository workoutPlanRepository;

    public TrainingDayController(TrainingDayRepository trainingDayRepository, WorkoutPlanRepository workoutPlanRepository) {
        this.trainingDayRepository = trainingDayRepository;
        this.workoutPlanRepository = workoutPlanRepository;
    }

    @PostMapping("/add")
    public String saveNewTrainingDay(Model model,@Valid TrainingDay trainingDay, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//           return "/workoutPlan/editPlan";
//        }

//        trainingDayRepository.save(trainingDay);
//        WorkoutPlan workoutPlanToEdit = (WorkoutPlan) model.getAttribute("workoutPlanToEdit");
//        System.out.println(workoutPlanToEdit.getId());
//        return "redirect:/plan/edit/" + model.getAttribute("planToEditId");
        //TU COS JEST ZJEBANE , JAK ZASSAC NUMER ID PLANU ZEBY WROCIC DO FORMULARZA EDYCJI
        return null;
    }
}
