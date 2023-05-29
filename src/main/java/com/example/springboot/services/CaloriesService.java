package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.beans.Profil;
import com.example.springboot.utils.CaloriesCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CaloriesService {

    private final ServiceGoal serviceGoal;
    private final ServiceProfil serviceProfil;
    private final CaloriesCalculator caloriesCalculator;

    public double getDailyCaloriesEstimation(UUID userId){
        Profil profil = this.serviceProfil.getProfilByUserId(userId);
        return this.caloriesCalculator.dailyCalorieEstimation(profil);
    }

    public double getGoalCaloriesEstimation(UUID userId) {
        Profil profil = this.serviceProfil.getProfilByUserId(userId);
        Goal goal = this.serviceGoal.getGoalByUserId(userId);
        return this.caloriesCalculator.goalCaloriesEstimation(profil, goal);
    }


}
