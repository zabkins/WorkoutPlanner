package com.zarczynski.service;

import com.zarczynski.entity.WorkoutPlan;
import com.zarczynski.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    private final WorkoutPlanRepository repository;

    public HomeService(WorkoutPlanRepository repository) {
        this.repository = repository;
    }

    public Optional<WorkoutPlan> getActivePlan() {
        return repository.getActiveWorkoutPlan();
    }

    public List<WorkoutPlan> getAllPlans() {
        return repository.findAll();
    }
}
