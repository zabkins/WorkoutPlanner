package com.zarczynski.service;

import com.zarczynski.entity.Exercise;
import com.zarczynski.entity.TrainingDay;
import com.zarczynski.entity.WorkoutPlan;
import com.zarczynski.repository.ExerciseRepository;
import com.zarczynski.repository.TrainingDayRepository;
import com.zarczynski.repository.WorkoutPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingDayService {


    private final TrainingDayRepository trainingDayRepository;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final ExerciseRepository exerciseRepository;

    public TrainingDayService(TrainingDayRepository trainingDayRepository, WorkoutPlanRepository workoutPlanRepository, ExerciseRepository exerciseRepository) {
        this.trainingDayRepository = trainingDayRepository;
        this.workoutPlanRepository = workoutPlanRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAllOrderedByName();
    }

    public Optional<WorkoutPlan> findPlanById(Long id) {
        return workoutPlanRepository.findById(id);
    }

    public WorkoutPlan savePlan(WorkoutPlan plan) {
        return workoutPlanRepository.save(plan);
    }

    public Long getWorkoutPlanIdByTrainingDayId(Long id) {
        return workoutPlanRepository.getWorkoutPlanIdByTrainingDayId(id);
    }

    public TrainingDay saveTrainingDay(TrainingDay trainingDay) {
        return trainingDayRepository.save(trainingDay);
    }

    public Optional<TrainingDay> findTrainingDay(Long id) {
        return trainingDayRepository.findById(id);
    }

    public void deleteExerciseFromTrainingDay(Long trainingDayId, Long exerciseId) {
        trainingDayRepository.deleteExerciseFromTrainingDayById(trainingDayId, exerciseId);
    }

    public void deleteTrainingDayFromPlan(Long id) {
        trainingDayRepository.deleteTrainingDayFromWorkoutPlan(id);
    }

    public void deleteTrainingDay(Long id) {
        trainingDayRepository.deleteById(id);
    }
}
