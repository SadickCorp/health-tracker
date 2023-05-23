package com.example.springboot.services;

import com.example.springboot.beans.Goal;
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

    public Goal getGoalById(UUID id) {
        return this.goalRepository.findById(id).orElse(null);
    }

    public Goal getGoalByProfilId(UUID id) {
        return this.goalRepository.getGoalByProfilId(id);
    }

    public Goal addGoal(Goal pgoal) {
        return this.goalRepository.saveAndFlush(pgoal);
    }

    public Goal updateGoal(UUID id, LightGoalDto lightGoalDto) {
        Goal goal = this.getGoalById(id);
        goal.update(lightGoalDto);
        return this.goalRepository.saveAndFlush(goal);
    }

    public void deleteGoal(UUID id) {
        this.goalRepository.deleteById(id);
        return;
    }
}
