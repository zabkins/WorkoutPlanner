package com.zarczynski.controller;

import com.zarczynski.entity.Exercise;
import com.zarczynski.entity.TrainingDay;
import com.zarczynski.entity.WorkoutPlan;
import com.zarczynski.repository.ExerciseRepository;
import com.zarczynski.repository.TrainingDayRepository;
import com.zarczynski.repository.WorkoutPlanRepository;
import com.zarczynski.service.TrainingDayService;
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

    private final TrainingDayService service;

    public TrainingDayController(TrainingDayService service) {
        this.service = service;
    }

    @ModelAttribute("exercises")
    public List<Exercise> getAllExercises() {
        return service.getAllExercises();
    }

    @GetMapping("/add/{workoutPlanId}")
    public String showFormForNewTrainingDay(Model model, @PathVariable Long workoutPlanId) {
        TrainingDay trainingDay = new TrainingDay();
        model.addAttribute("trainingDay", trainingDay);
        Optional<WorkoutPlan> workoutPlanToEditOpt = service.findPlanById(workoutPlanId);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("workoutPlanToEdit", workoutPlanToEdit);
        return "/trainingDay/add";
    }

    @PostMapping("/add/{workoutPlanId}")
    public String saveNewTrainingDay(Model model, @PathVariable Long workoutPlanId, @Valid TrainingDay trainingDay, BindingResult bindingResult) {
        Optional<WorkoutPlan> workoutPlanToEditOpt = service.findPlanById(workoutPlanId);
        WorkoutPlan workoutPlanToEdit = workoutPlanToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (bindingResult.hasErrors()) {
            model.addAttribute("workoutPlanToEdit", workoutPlanToEdit);
            return "/trainingDay/add";
        }
        service.saveTrainingDay(trainingDay);
        List<TrainingDay> trainingDayList = new ArrayList<>();
        if (workoutPlanToEdit.getTrainingDays() != null) {
            trainingDayList = workoutPlanToEdit.getTrainingDays();
        }
        trainingDayList.add(trainingDay);
        workoutPlanToEdit.setTrainingDays(trainingDayList);
        service.savePlan(workoutPlanToEdit);
        model.addAttribute("trainingDayToEdit", trainingDay);
        return "/trainingDay/edit";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        Optional<TrainingDay> trainingDayToEditOpt = service.findTrainingDay(id);
        TrainingDay trainingDayToEdit = trainingDayToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("trainingDayToEdit", trainingDayToEdit);
        return "/trainingDay/edit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditForm(Model model, @PathVariable Long id, TrainingDay trainingDay) {
        Optional<TrainingDay> trainingDayToEditOpt = service.findTrainingDay(id);
        TrainingDay trainingDayToEdit = trainingDayToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Exercise> existingExercises = trainingDayToEdit.getExercises();
        if (!existingExercises.contains(trainingDay.getExercises().get(0))) {
            existingExercises.add(trainingDay.getExercises().get(0));
        }
        trainingDay.setExercises(existingExercises);
        service.saveTrainingDay(trainingDay);
        model.addAttribute("trainingDayToEdit", trainingDay);
        return "/trainingDay/edit";
    }

    @GetMapping("/delete/{trainingDayId}/{exerciseId}")
    public String deleteExercise(Model model, @PathVariable Long trainingDayId, @PathVariable Long exerciseId) {
        Optional<TrainingDay> trainingDayToEditOpt = service.findTrainingDay(trainingDayId);
        TrainingDay trainingDayToEdit = trainingDayToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        service.deleteExerciseFromTrainingDay(trainingDayId, exerciseId);
        model.addAttribute("trainingDayToEdit", trainingDayToEdit);
        return "/trainingDay/edit";
    }

    @GetMapping("/redirect/{id}")
    public String redirectBackToPlan(@PathVariable Long id) {
        Long workoutPlanId = service.getWorkoutPlanIdByTrainingDayId(id);
        return String.format("redirect:/plan/edit/%d", workoutPlanId);
    }

    @GetMapping("/edit/name/{id}")
    public String showNameEditForm(Model model, @PathVariable Long id) {
        Optional<TrainingDay> trainingDayToEditOpt = service.findTrainingDay(id);
        TrainingDay trainingDayToEdit = trainingDayToEditOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("trainingDayToEdit", trainingDayToEdit);
        return "/trainingDay/editName";
    }

    @PostMapping("/edit/name")
    public String saveNameEditForm(@Valid @ModelAttribute("trainingDayToEdit") TrainingDay trainingDay, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/trainingDay/editName";
        }
        service.saveTrainingDay(trainingDay);
        return String.format("redirect:/tday/edit/%d", trainingDay.getId());
    }

    @GetMapping("/delete/{id}")
    public String redirectToDeletConfirmation(Model model, @PathVariable Long id) {
        Optional<TrainingDay> trainingDayToDeleteOpt = service.findTrainingDay(id);
        TrainingDay trainingDayToDelete = trainingDayToDeleteOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("trainingDayToDelete", trainingDayToDelete);
        return "/trainingDay/confirmDelete";
    }

    @GetMapping("/delete/confirm/{id}")
    public String deleteConfirmedDay(@PathVariable Long id) {
        Long workoutPlanId = service.getWorkoutPlanIdByTrainingDayId(id);
        service.deleteTrainingDayFromPlan(id);
        service.deleteTrainingDay(id);
        return String.format("redirect:/tday/redirect/%d", workoutPlanId);
    }

}
