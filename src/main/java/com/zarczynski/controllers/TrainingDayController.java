package com.zarczynski.controllers;

import com.zarczynski.entities.Exercise;
import com.zarczynski.entities.TrainingDay;
import com.zarczynski.entities.WorkoutPlan;
import com.zarczynski.repositories.ExerciseRepository;
import com.zarczynski.repositories.TrainingDayRepository;
import com.zarczynski.repositories.WorkoutPlanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tday")
public class TrainingDayController {

    private final TrainingDayRepository trainingDayRepository;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final ExerciseRepository exerciseRepository;

    public TrainingDayController(TrainingDayRepository trainingDayRepository, WorkoutPlanRepository workoutPlanRepository, ExerciseRepository exerciseRepository) {
        this.trainingDayRepository = trainingDayRepository;
        this.workoutPlanRepository = workoutPlanRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @ModelAttribute("exercises")
    public List<Exercise> getAllExercises(){
        return exerciseRepository.findAllOrderedByName();
    }

    @GetMapping("/add/{workoutPlanId}")
    public String showFormForNewTrainingDay(Model model, @PathVariable Long workoutPlanId){
        TrainingDay trainingDay = new TrainingDay();
        model.addAttribute("trainingDay",trainingDay);
        Optional<WorkoutPlan> workoutPlanToEditOpt = workoutPlanRepository.findById(workoutPlanId);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToEdit",workoutPlanToEdit);
        return "/trainingDay/add";
    }

    @PostMapping("/add/{workoutPlanId}")
    public String saveNewTrainingDay(Model model, @PathVariable Long workoutPlanId, @Valid TrainingDay trainingDay, BindingResult bindingResult){
        Optional<WorkoutPlan> workoutPlanToEditOpt = workoutPlanRepository.findById(workoutPlanId);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if(bindingResult.hasErrors()){
            model.addAttribute("workoutPlanToEdit",workoutPlanToEdit);
            return "/trainingDay/add";
        }
        trainingDayRepository.save(trainingDay);
        List<TrainingDay> trainingDayList = new ArrayList<>();
        if(workoutPlanToEdit.getTrainingDays() != null){
            trainingDayList = workoutPlanToEdit.getTrainingDays();
        }
        trainingDayList.add(trainingDay);
        workoutPlanToEdit.setTrainingDays(trainingDayList);
        workoutPlanRepository.save(workoutPlanToEdit);
        model.addAttribute("trainingDayToEdit",trainingDay);
        return "/trainingDay/edit";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id){
        Optional<TrainingDay> trainingDayToEditOpt = trainingDayRepository.findById(id);
        TrainingDay trainingDayToEdit = trainingDayToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("trainingDayToEdit",trainingDayToEdit);
        return "/trainingDay/edit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditForm(Model model,@PathVariable Long id, TrainingDay trainingDay){
        Optional<TrainingDay> trainingDayToEditOpt = trainingDayRepository.findById(id);
        TrainingDay trainingDayToEdit = trainingDayToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Exercise> existingExercises = trainingDayToEdit.getExercises();
        existingExercises.addAll(trainingDay.getExercises());
        trainingDay.setExercises(existingExercises);
        trainingDayRepository.save(trainingDay);
        model.addAttribute("trainingDayToEdit",trainingDay);
        return "/trainingDay/edit";
    }

    @GetMapping("/delete/{trainingDayId}/{exerciseId}")
    public String deleteExercise(Model model, @PathVariable Long trainingDayId, @PathVariable Long exerciseId){
        Optional<TrainingDay> trainingDayToEditOpt = trainingDayRepository.findById(trainingDayId);
        TrainingDay trainingDayToEdit = trainingDayToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        trainingDayRepository.deleteExerciseFromTrainingDayById(trainingDayId,exerciseId);
        model.addAttribute("trainingDayToEdit",trainingDayToEdit);
        return "/trainingDay/edit";
    }

    @GetMapping("/redirect/{id}")
    public String redirectBackToPlan(@PathVariable Long id){
        Long workoutPlanId = workoutPlanRepository.getWorkoutPlanIdByTrainingDayId(id);
        return String.format("redirect:/plan/edit/%d",workoutPlanId);
    }


}
