package com.zarczynski.repositories;

import com.zarczynski.entities.TrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainingDayRepository extends JpaRepository<TrainingDay, Long> {

}
