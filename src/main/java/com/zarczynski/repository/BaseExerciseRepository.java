package com.zarczynski.repository;


import com.zarczynski.entity.BaseExercise;
import com.zarczynski.entity.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseExerciseRepository extends JpaRepository<BaseExercise, Long> {
    List<BaseExercise> findBaseExercisesByMuscleGroup(MuscleGroup muscleGroup);
}
