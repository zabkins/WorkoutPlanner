package com.zarczynski.controllers;

import com.zarczynski.entities.TrainingDay;
import com.zarczynski.entities.WorkoutPlan;
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

    public TrainingDayController(TrainingDayRepository trainingDayRepository, WorkoutPlanRepository workoutPlanRepository) {
        this.trainingDayRepository = trainingDayRepository;
        this.workoutPlanRepository = workoutPlanRepository;
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
        /// DZIALA , CZYLI TU MOGE ZROBIC PRZEKIROWANIE TO EDYCJI DNIA TRENINGOWEGO - tam bede dodawal cwiczenia itp.
        /// DO przemyslenia czy sprobowac zrobic formularz, z dodawaniem dynamicznym serii (moze zmodyfikowac exerciseSet i dodac relacje
        //dwustronna czyli zeby odrazu przypisana przy tworzeniu byla do WholeExercise?

        //    @ManyToOne
        //    private WholeExercise wholeExercise;  <----- to dodac w ExerciseSet
        //      tu chyba musialbym uzyc JavaScript zeby to jakos dynamicznie wyswietlac i dodawac
        // Wyglad tak jak w EditPlan.jsp

        //Albo usunac WholeExercise i ExerciseSet i po prostu zrobic Training day - List<BaseExercise>???
        return String.format("redirect:/plan/edit/%d",workoutPlanToEdit.getId());
    }

}
