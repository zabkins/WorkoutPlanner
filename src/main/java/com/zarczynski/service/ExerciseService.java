package com.zarczynski.service;

import com.zarczynski.entity.Exercise;
import com.zarczynski.entity.MuscleGroup;
import com.zarczynski.repository.ExerciseRepository;
import com.zarczynski.repository.MuscleGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    private final MuscleGroupRepository muscleGroupRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, MuscleGroupRepository muscleGroupRepository) {
        this.exerciseRepository = exerciseRepository;
        this.muscleGroupRepository = muscleGroupRepository;
    }

    public List<MuscleGroup> findAll() {
        return muscleGroupRepository.findAll();
    }

    public List<Exercise> getAllExercisesOrderedByName() {
        return exerciseRepository.findAllOrderedByName();
    }

    public MuscleGroup findMuscleGroup(Long id) {
        return muscleGroupRepository.getById(id);
    }
    
    public List<Exercise> findExercises(MuscleGroup muscleGroup) {
        return exerciseRepository.findExercisesByMuscleGroupOrderByName(muscleGroup);
    }
    
    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Optional<Exercise> findExercise (Long id) {
        return exerciseRepository.findById(id);
    }

    public void deleteExerciseFromTrainigDay (Long id) {
        exerciseRepository.deleteExerciseFromTrainingDaysById(id);
    }

    public void deleteExercise (Long id) {
        exerciseRepository.deleteById(id);
    }
}
