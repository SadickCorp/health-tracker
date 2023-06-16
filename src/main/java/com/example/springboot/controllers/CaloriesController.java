package com.example.springboot.controllers;

import com.example.springboot.services.CaloriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<Double> getGoalCaloriesEstimation(@RequestHeader(name="Authorization") String token, @PathVariable("userId") UUID userId) {
        return ResponseEntity
                .ok()
                .body(this.caloriesService.getGoalCaloriesEstimation(userId, token));
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<Double> getRecipeAmountOfCalories(@PathVariable("recipeId") UUID recipeId) {
        return ResponseEntity
                .ok()
                .body(this.caloriesService.getRecipeAmountOfCalories(recipeId));
    }

    @GetMapping("/daily/{userId}/{date}")
    public ResponseEntity<Double> getDailyAmountOfCalories(
            @PathVariable("userId") UUID userId,
            @PathVariable("date")LocalDate date
            ){
        return ResponseEntity
                .ok()
                .body(this.caloriesService.getDailyAmountOfCalories(userId, date));
    }
}
