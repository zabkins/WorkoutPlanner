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

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query("UPDATE WorkoutPlan w SET w.active = false WHERE w.active = true")
    void setAllActiveWorkoutPlansInactive();
}
