package com.zarczynski.controllers;

import com.zarczynski.entities.BaseExercise;
import com.zarczynski.entities.MuscleGroup;
import com.zarczynski.repositories.BaseExerciseRepository;
import com.zarczynski.repositories.MuscleGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/exercise/base")
public class BaseExerciseController {

    private final BaseExerciseRepository baseExerciseRepository;
    private final MuscleGroupRepository muscleGroupRepository;

    public BaseExerciseController(BaseExerciseRepository baseExerciseRepository, MuscleGroupRepository muscleGroupRepository) {
        this.baseExerciseRepository = baseExerciseRepository;
        this.muscleGroupRepository = muscleGroupRepository;
    }

    @ModelAttribute("muscleGroups")
    public List<MuscleGroup> getAllMuscleGroups(){
        return muscleGroupRepository.findAll();
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        BaseExercise baseExercise = new BaseExercise();
        model.addAttribute("baseExercise",baseExercise);
        List<BaseExercise> baseExercisesToBeShown = baseExerciseRepository.findAllOrderedByName();
        model.addAttribute("baseExercisesToBeShown",baseExercisesToBeShown);
        return "/baseExercise/addExercise";
    }

    @GetMapping("/add/{id}")
    public String showAddFormWithChosenGroupMusclesForExerciseList(Model model, @PathVariable Long id){
        BaseExercise baseExercise = new BaseExercise();
        model.addAttribute("baseExercise",baseExercise);
        MuscleGroup chosenMuscleGroup = muscleGroupRepository.getById(id);
        List<BaseExercise> baseExercisesToBeShown = baseExerciseRepository.findBaseExercisesByMuscleGroupOrderByName(chosenMuscleGroup);
        model.addAttribute("baseExercisesToBeShown",baseExercisesToBeShown);
        return "/baseExercise/addExercise";
    }

    @PostMapping("/add")
    public String saveAddForm(Model model, @Valid BaseExercise baseExercise, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<BaseExercise> baseExercisesToBeShown = baseExerciseRepository.findAllOrderedByName();
            model.addAttribute("baseExercisesToBeShown",baseExercisesToBeShown);
            return "/baseExercise/addExercise";
        }
        baseExerciseRepository.save(baseExercise);
        return "redirect:/exercise/base/add";
    }

    @GetMapping("/list")
    public String showAllBasicExercises(Model model){
        List<BaseExercise> baseExercisesToBeShown = baseExerciseRepository.findAllOrderedByName();
        model.addAttribute("baseExercisesToBeShown",baseExercisesToBeShown);
        return "/baseExercise/list";
    }

    @GetMapping("/list/{id}")
    public String showAllBasicExercisesForGivenMuscleGroup(Model model, @PathVariable Long id){
        MuscleGroup chosenMuscleGroup = muscleGroupRepository.getById(id);
        List<BaseExercise> baseExercisesToBeShown = baseExerciseRepository.findBaseExercisesByMuscleGroupOrderByName(chosenMuscleGroup);
        model.addAttribute("baseExercisesToBeShown",baseExercisesToBeShown);
        return "/baseExercise/list";
    }

    @GetMapping("/details/{id}")
    public String showExerciseDetails(Model model, @PathVariable Long id){
        BaseExercise baseExerciseToDetail = baseExerciseRepository.getById(id);
        model.addAttribute("baseExerciseToDetail",baseExerciseToDetail);
        return "/baseExercise/exerciseDetails";
    }
}
