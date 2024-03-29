package com.zarczynski.repository;

import com.zarczynski.entity.TrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM training_day_exercises WHERE training_day_id = ?1 AND exercises_id = ?2",nativeQuery = true)
    void deleteExerciseFromTrainingDayById(Long trainingDayId,Long exerciseId);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM workout_plan_training_days WHERE training_days_id = ?1",nativeQuery = true)
    void deleteTrainingDayFromWorkoutPlan(Long trainingDayId);

}
