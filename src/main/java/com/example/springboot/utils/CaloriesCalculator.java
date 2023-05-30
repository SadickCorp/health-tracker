package com.example.springboot.utils;

import com.example.springboot.beans.Food;
import com.example.springboot.beans.Goal;
import com.example.springboot.beans.Profil;
import com.example.springboot.beans.Recipe;
import com.example.springboot.enums.EUserSexe;
import com.example.springboot.services.ServiceGoal;
import com.example.springboot.services.ServiceProfil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class CaloriesCalculator {
    public double dailyCalorieEstimation(Profil profil){
        if(profil.getSexe() == EUserSexe.MAN){
            return 66.5 + (13.75 * profil.getWeight()) + (5 * profil.getHeight()) - (6.75 * this.ageCalculator(profil.getBirth()));
        }else {
            return 655.1 + (9.56 * profil.getWeight()) + (1.85 * profil.getHeight()) - (4.68 * this.ageCalculator(profil.getBirth()));
        }
    }

    public int ageCalculator(LocalDate birth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birth, currentDate).getYears();
    }

    public double goalCaloriesEstimation(Profil profil, Goal goal){
        boolean isPositiveGoal = goal.getActual_weight() < goal.getGoal_weight();
        boolean isGoalAchieved = goal.getActual_weight() == goal.getGoal_weight();
        if(isGoalAchieved) {
            return this.dailyCalorieEstimation(profil);
        }
        return isPositiveGoal ? this.dailyCalorieEstimation(profil) + 500 : this.dailyCalorieEstimation(profil) - 500;
    }

    public double recipeAmountOfCalories(Recipe recipe) {
        List<Food> foods = recipe.getFoods();
        double amount = 0.0;
        for(Food food : foods){
            amount += food.getCalorie();
        }
        return amount;
    }

    public double dailyAmountOfCalories(List<Recipe> recipes){
        double amount = 0.0;
        for(Recipe recipe : recipes){
            amount += this.recipeAmountOfCalories(recipe);
        }
        return amount;
    }
}
