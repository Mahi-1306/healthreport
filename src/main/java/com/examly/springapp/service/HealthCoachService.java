package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.InvalidExperienceException;
import com.examly.springapp.model.HealthCoach;
import com.examly.springapp.repository.HealthCoachRepo;

@Service
public class HealthCoachService {

    @Autowired
    private HealthCoachRepo repo;

    // Fetch all coaches
    public List<HealthCoach> getAllCoaches() {
        return repo.findAll();
    }

    // Add a new coach
    public HealthCoach addCoach(HealthCoach coach) {
        if (coach.getExperience() < 0) {
            throw new InvalidExperienceException("Experience cannot be negative.");
        }
        return repo.save(coach);
    }
}
