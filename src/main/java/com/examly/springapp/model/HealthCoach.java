package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Generates no-args constructor
@AllArgsConstructor // Generates all-args constructor
public class HealthCoach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialization;
    private String certification;
    private int experience;
    private String phoneNumber;
}
