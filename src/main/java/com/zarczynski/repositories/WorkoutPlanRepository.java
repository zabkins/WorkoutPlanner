package com.zarczynski.repositories;

import com.zarczynski.entities.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {

    @Query(value = "SELECT * FROM workout_plan WHERE active IS TRUE", nativeQuery = true)
    Optional<WorkoutPlan> getActiveWorkoutPlan();


    @Query(value = "SELECT workout_plan_id FROM workout_plan_training_days WHERE training_days_id = ?1", nativeQuery = true)
    Long getWorkoutPlanIdByTrainingDayId(Long trainingDayId);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("UPDATE WorkoutPlan w SET w.active = false WHERE w.active = true")
    void setAllActiveWorkoutPlansInactive();

    @Modifying
    @Transactional
    @Query("UPDATE WorkoutPlan w SET w.active = true WHERE w.id = ?1")
    void setWorkoutPlanActiveById(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM workout_plan_training_days WHERE workout_plan_id = ?1", nativeQuery = true)
    void deleteWorkoutPlanTrainingDaysPlanByPlanId(Long id);
}
