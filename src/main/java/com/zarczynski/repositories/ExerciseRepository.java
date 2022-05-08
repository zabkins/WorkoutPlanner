package com.zarczynski.repositories;


import com.zarczynski.entities.Exercise;
import com.zarczynski.entities.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findExercisesByMuscleGroupOrderByName(MuscleGroup muscleGroup);

    @Query(value = "SELECT * FROM exercise ORDER BY name", nativeQuery = true)
    List<Exercise> findAllOrderedByName();

    @Query(value = "SELECT * FROM exercise e JOIN muscle_group mg on mg.id = e.muscle_group_id ORDER BY  mg.name", nativeQuery = true)
    List<Exercise> findAllOrderedByMuscleGroupName();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM training_day_exercises WHERE exercises_id = ?1", nativeQuery = true)
    void deleteExerciseFromTrainingDaysById(Long exerciseId);
}
