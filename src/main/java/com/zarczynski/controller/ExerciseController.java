package com.zarczynski.controller;

import com.zarczynski.entity.Exercise;
import com.zarczynski.entity.MuscleGroup;
import com.zarczynski.repository.ExerciseRepository;
import com.zarczynski.repository.MuscleGroupRepository;
import com.zarczynski.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService service;

    public ExerciseController(ExerciseService service) {
        this.service = service;
    }

    @ModelAttribute("muscleGroups")
    public List<MuscleGroup> getAllMuscleGroups(){
        return service.findAll();
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        Exercise exercise = new Exercise();
        model.addAttribute("exercise", exercise);
        List<Exercise> exercisesToBeShown = service.getAllExercisesOrderedByName();
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/addExercise";
    }

    @GetMapping("/add/{id}")
    public String showAddFormWithChosenGroupMusclesForExerciseList(Model model, @PathVariable Long id){
        Exercise exercise = new Exercise();
        model.addAttribute("exercise", exercise);
        MuscleGroup chosenMuscleGroup = service.findMuscleGroup(id);
        List<Exercise> exercisesToBeShown = service.findExercises(chosenMuscleGroup);
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/addExercise";
    }

    @PostMapping("/add")
    public String saveAddForm(Model model, @Valid Exercise exercise, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<Exercise> exercisesToBeShown = service.getAllExercisesOrderedByName();
            model.addAttribute("exercisesToBeShown", exercisesToBeShown);
            return "/exercise/addExercise";
        }
        service.saveExercise(exercise);
        return "redirect:/exercise/add";
    }

    @GetMapping("/list")
    public String showAllBasicExercises(Model model){
        List<Exercise> exercisesToBeShown = service.getAllExercisesOrderedByName();
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/list";
    }

    @GetMapping("/list/{id}")
    public String showAllBasicExercisesForGivenMuscleGroup(Model model, @PathVariable Long id){
        MuscleGroup chosenMuscleGroup = service.findMuscleGroup(id);
        List<Exercise> exercisesToBeShown = service.findExercises(chosenMuscleGroup);
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/list";
    }

    @GetMapping("/details/{id}")
    public String showExerciseDetails(Model model, @PathVariable Long id){
        Exercise exerciseToDetail = service.findExercise(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("exerciseToDetail", exerciseToDetail);
        return "/exercise/exerciseDetails";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(Model model, @PathVariable Long id){
        Optional<Exercise> exerciseToDeleteOpt = service.findExercise(id);
        Exercise exerciseToDelete = exerciseToDeleteOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("exerciseToDelete",exerciseToDelete);
        return "/exercise/confirmDelete";
    }

    @GetMapping("/delete/confirm/{id}")
    public String deleteConfirmedExercise(@PathVariable Long id){
        service.deleteExerciseFromTrainigDay(id);
        service.deleteExercise(id);
        return "redirect:/exercise/list";
    }
}
