package com.zarczynski.controllers;

import com.zarczynski.entity.BaseExercise;
import com.zarczynski.entity.MuscleGroup;
import com.zarczynski.repository.BaseExerciseRepository;
import com.zarczynski.repository.MuscleGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<BaseExercise> allBaseExercises = baseExerciseRepository.findAllOrderedByMuscleGroupName();
        model.addAttribute("baseExercise",baseExercise);
        model.addAttribute("allBaseExercisesSorted",allBaseExercises);
        return "/baseExercise/addExercise";
    }

    @PostMapping("/add")
    public String saveAddForm(Model model, @Valid BaseExercise baseExercise, BindingResult bindingResult){
        List<BaseExercise> allBaseExercises = baseExerciseRepository.findAllOrderedByMuscleGroupName();
        model.addAttribute("allBaseExercisesSorted",allBaseExercises);
        if(bindingResult.hasErrors()){
            return "/baseExercise/addExercise";
        }
        baseExerciseRepository.save(baseExercise);
        return "redirect:/exercise/base/add";
    }


}
