package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.beans.Profil;
import com.example.springboot.beans.Recipe;
import com.example.springboot.utils.CaloriesCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CaloriesService {

    private final ServiceGoal serviceGoal;
    private final ServiceProfil serviceProfil;
    private final CaloriesCalculator caloriesCalculator;

    private final ServiceRecipe serviceRecipe;

    public double getDailyCaloriesEstimation(UUID userId){
        Profil profil = this.serviceProfil.getProfilByUserId(userId);
        return this.caloriesCalculator.dailyCalorieEstimation(profil);
    }

    public double getGoalCaloriesEstimation(UUID userId) {
        Profil profil = this.serviceProfil.getProfilByUserId(userId);
        Goal goal = this.serviceGoal.getGoalByUserId(userId);
        return this.caloriesCalculator.goalCaloriesEstimation(profil, goal);
    }

    public double getRecipeAmountOfCalories(UUID recipeId) {
        Recipe recipe = this.serviceRecipe.getRecipeById(recipeId);
        return this.caloriesCalculator.recipeAmountOfCalories(recipe);
    }

    public double getDailyAmountOfCalories(UUID userId, LocalDate date) {
        List<Recipe> recipeList = this.serviceRecipe.getRecipeByDate(userId, date);
        return this.caloriesCalculator.dailyAmountOfCalories(recipeList);
    }


}
