package com.zarczynski;

import com.zarczynski.controller.ExerciseController;
import com.zarczynski.controller.HomeController;
import com.zarczynski.controller.TrainingDayController;
import com.zarczynski.controller.WorkoutPlanController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WorkoutPlannerApplicationTest {

    @Autowired
    private HomeController homeController;
    @Autowired
    private ExerciseController exerciseController;
    @Autowired
    private TrainingDayController trainingDayController;
    @Autowired
    private WorkoutPlanController workoutPlanController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(homeController).isNotNull();
        assertThat(exerciseController).isNotNull();
        assertThat(trainingDayController).isNotNull();
        assertThat(workoutPlanController).isNotNull();
    }
}