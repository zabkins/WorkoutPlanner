package com.zarczynski.controllers;

import com.zarczynski.entities.Exercise;
import com.zarczynski.entities.MuscleGroup;
import com.zarczynski.repositories.ExerciseRepository;
import com.zarczynski.repositories.MuscleGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final MuscleGroupRepository muscleGroupRepository;

    public ExerciseController(ExerciseRepository exerciseRepository, MuscleGroupRepository muscleGroupRepository) {
        this.exerciseRepository = exerciseRepository;
        this.muscleGroupRepository = muscleGroupRepository;
    }

    @ModelAttribute("muscleGroups")
    public List<MuscleGroup> getAllMuscleGroups(){
        return muscleGroupRepository.findAll();
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        Exercise exercise = new Exercise();
        model.addAttribute("exercise", exercise);
        List<Exercise> exercisesToBeShown = exerciseRepository.findAllOrderedByName();
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/addExercise";
    }

    @GetMapping("/add/{id}")
    public String showAddFormWithChosenGroupMusclesForExerciseList(Model model, @PathVariable Long id){
        Exercise exercise = new Exercise();
        model.addAttribute("exercise", exercise);
        MuscleGroup chosenMuscleGroup = muscleGroupRepository.getById(id);
        List<Exercise> exercisesToBeShown = exerciseRepository.findExercisesByMuscleGroupOrderByName(chosenMuscleGroup);
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/addExercise";
    }

    @PostMapping("/add")
    public String saveAddForm(Model model, @Valid Exercise exercise, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<Exercise> exercisesToBeShown = exerciseRepository.findAllOrderedByName();
            model.addAttribute("exercisesToBeShown", exercisesToBeShown);
            return "/exercise/addExercise";
        }
        exerciseRepository.save(exercise);
        return "redirect:/exercise/add";
    }

    @GetMapping("/list")
    public String showAllBasicExercises(Model model){
        List<Exercise> exercisesToBeShown = exerciseRepository.findAllOrderedByName();
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/list";
    }

    @GetMapping("/list/{id}")
    public String showAllBasicExercisesForGivenMuscleGroup(Model model, @PathVariable Long id){
        MuscleGroup chosenMuscleGroup = muscleGroupRepository.getById(id);
        List<Exercise> exercisesToBeShown = exerciseRepository.findExercisesByMuscleGroupOrderByName(chosenMuscleGroup);
        model.addAttribute("exercisesToBeShown", exercisesToBeShown);
        return "/exercise/list";
    }

    @GetMapping("/details/{id}")
    public String showExerciseDetails(Model model, @PathVariable Long id){
        Exercise exerciseToDetail = exerciseRepository.getById(id);
        model.addAttribute("exerciseToDetail", exerciseToDetail);
        return "/exercise/exerciseDetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteExerciseById(@PathVariable Long id){
        exerciseRepository.deleteById(id);
        return "redirect:/exercise/list";
    }
}
