package com.zarczynski.controllers;

import com.zarczynski.entity.BaseExercise;
import com.zarczynski.entity.MuscleGroup;
import com.zarczynski.repository.BaseExerciseRepository;
import com.zarczynski.repository.MuscleGroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/add")
    public String showAddForm(Model model){
        BaseExercise baseExercise = new BaseExercise();
        List<MuscleGroup> muscleGroups = muscleGroupRepository.findAll();
        model.addAttribute("baseExercise",baseExercise);
        model.addAttribute("muscleGroups",muscleGroups);
        return "/baseExercise/addExercise";
    }

    @PostMapping("/add")
    public String saveAddForm(Model model, @Valid BaseExercise baseExercise, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<MuscleGroup> muscleGroups = muscleGroupRepository.findAll();
            model.addAttribute("muscleGroups",muscleGroups);
            return "/baseExercise/addExercise";
        }
        baseExerciseRepository.save(baseExercise);
        return "/baseExercise/list";
    }


}
