package com.zarczynski.repository;

import com.zarczynski.entity.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {

}
