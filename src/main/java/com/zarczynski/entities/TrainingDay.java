package com.zarczynski.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "training_day")
public class TrainingDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany
    private List<WholeExercise> wholeExercises;

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

    public List<WholeExercise> getWholeExercises() {
        return wholeExercises;
    }

    public void setWholeExercises(List<WholeExercise> wholeExercises) {
        this.wholeExercises = wholeExercises;
    }
}
