package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.HealthCoach;

public interface HealthCoachRepo extends JpaRepository<HealthCoach, Integer> {
}
