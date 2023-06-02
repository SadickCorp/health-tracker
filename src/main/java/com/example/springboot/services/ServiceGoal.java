package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.beans.Monitoring;
import com.example.springboot.dto.light.LightGoalDto;
import com.example.springboot.repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ServiceGoal implements IServiceGoal {

    private final GoalRepository goalRepository;
    private final ServiceUser serviceUser;
    private final ServiceMonitoring serviceMonitoring;

    public Goal getGoalById(UUID id) {
        return this.goalRepository.findById(id).orElse(null);
    }

    public Goal getGoalByUserId(UUID id) {
        return this.goalRepository.getGoalByUserId(id);
    }

    public Goal addGoal(Goal pgoal) {
        return this.goalRepository.saveAndFlush(pgoal);
    }

    public Goal updateGoal(UUID id, LightGoalDto lightGoalDto) {
        Goal goal = this.getGoalByUserId(id);
        if(goal.getActual_weight() != lightGoalDto.getActual_weight()){
            Monitoring monitoring = new Monitoring();
            monitoring.setWeight(lightGoalDto.getActual_weight());
            monitoring.setUser(this.serviceUser.getUserById(id));
            this.serviceMonitoring.addMonitoring(monitoring);
        }
        goal.update(lightGoalDto);
        return this.goalRepository.saveAndFlush(goal);
    }

    public void deleteGoal(UUID id) {
        this.goalRepository.deleteById(id);
        return;
    }
}
