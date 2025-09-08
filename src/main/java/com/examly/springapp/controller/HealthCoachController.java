package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.HealthCoach;
import com.examly.springapp.service.HealthCoachService;
import com.examly.springapp.exception.InvalidExperienceException;

@RestController
public class HealthCoachController {

    @Autowired
    private HealthCoachService service;

    // GET /getAllCoaches → Fetch all coaches
    @GetMapping("/getAllCoaches")
    public ResponseEntity<List<HealthCoach>> getAllCoaches() {
        List<HealthCoach> coaches = service.getAllCoaches();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    // POST /addCoach → Add a new coach
    @PostMapping("/addCoach")
    public ResponseEntity<HealthCoach> addCoach(@RequestBody HealthCoach coach) {
        HealthCoach savedCoach = service.addCoach(coach);
        return new ResponseEntity<>(savedCoach, HttpStatus.CREATED);
    }

    // Handle Invalid Experience Exception
    @ExceptionHandler(InvalidExperienceException.class)
    public ResponseEntity<String> handleInvalidExperience(InvalidExperienceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
