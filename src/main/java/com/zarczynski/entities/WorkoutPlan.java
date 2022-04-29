package com.zarczynski.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "workout_plan")
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{workoutPlanName.notblank}")
    private String name;
    @OneToMany
    private List<TrainingDay> trainingDays;
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrainingDay> getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(List<TrainingDay> trainingDays) {
        this.trainingDays = trainingDays;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
