package com.zarczynski.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "exercise")
public class WholeExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @ManyToOne
    private BaseExercise baseExercise;
    @NotBlank
    @OneToMany
    private List<ExerciseSet> exerciseSets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseExercise getBaseExercise() {
        return baseExercise;
    }

    public void setBaseExercise(BaseExercise baseExercise) {
        this.baseExercise = baseExercise;
    }

    public List<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(List<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
}
