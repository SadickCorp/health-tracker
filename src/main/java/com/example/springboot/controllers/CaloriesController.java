package com.example.springboot.controllers;

import com.example.springboot.services.CaloriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calories")
public class CaloriesController {

    private final CaloriesService caloriesService;

    @GetMapping("/daily/{userId}")
    public ResponseEntity<Double> getDailyCaloriesEstimation(@PathVariable("userId")UUID userId){
        return ResponseEntity
                .ok()
                .body(this.caloriesService.getDailyCaloriesEstimation(userId));
    }

    @GetMapping("/goal/{userId}")
    public ResponseEntity<Double> getGoalCaloriesEstimation(@PathVariable("userId") UUID userId) {
        return ResponseEntity
                .ok()
                .body(this.caloriesService.getGoalCaloriesEstimation(userId));
    }
}
