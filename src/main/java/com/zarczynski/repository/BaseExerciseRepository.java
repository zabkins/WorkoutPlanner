package com.zarczynski.repository;


import com.zarczynski.entity.BaseExercise;
import com.zarczynski.entity.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaseExerciseRepository extends JpaRepository<BaseExercise, Long> {
    List<BaseExercise> findBaseExercisesByMuscleGroupOrderByName(MuscleGroup muscleGroup);

    @Query(value = "SELECT * FROM base_exercise ORDER BY name", nativeQuery = true)
    List<BaseExercise> findAllOrderedByName();

    @Query(value = "SELECT * FROM base_exercise be JOIN muscle_group mg on mg.id = be.muscle_group_id ORDER BY  mg.name", nativeQuery = true)
    List<BaseExercise> findAllOrderedByMuscleGroupName();
}
