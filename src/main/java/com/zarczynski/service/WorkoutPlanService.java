package com.zarczynski.service;

import com.zarczynski.entity.WorkoutPlan;
import com.zarczynski.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutPlanService {

    private final WorkoutPlanRepository workoutPlanRepository;

    public WorkoutPlanService(WorkoutPlanRepository workoutPlanRepository) {
        this.workoutPlanRepository = workoutPlanRepository;
    }

    public void setAllActivePlansInactive() {
        workoutPlanRepository.setAllActiveWorkoutPlansInactive();
    }

    public WorkoutPlan savePlan (WorkoutPlan plan) {
        return workoutPlanRepository.save(plan);
    }

    public Optional<WorkoutPlan> findPlan(Long id) {
        return workoutPlanRepository.findById(id);
    }

    public void setWorkoutPlanActive (Long id) {
        workoutPlanRepository.setWorkoutPlanActiveById(id);
    }

    public void deletePlansTrainingDayById (Long id) {
        workoutPlanRepository.deleteWorkoutPlanTrainingDaysPlanByPlanId(id);
    }

    public void deletePlan (Long id) {
        workoutPlanRepository.deleteById(id);
    }
}
