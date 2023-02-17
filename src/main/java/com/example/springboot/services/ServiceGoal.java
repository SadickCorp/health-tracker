package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.dto.light.LightGoalDto;
import com.example.springboot.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class ServiceGoal implements IServiceGoal {

    private final GoalRepository goalRepository;

    public ServiceGoal(GoalRepository goalRepository){
        this.goalRepository = goalRepository;
    }

    public Goal getGoalById(long id) {
        return this.goalRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No entity found for " + id));
    }

    public Goal getGoalByProfilId(long id) {
        return this.goalRepository.getGoalByProfilId(id);
    }

    public Goal addGoal(Goal pgoal) {
        return this.goalRepository.saveAndFlush(pgoal);
    }

    public Goal updateGoal(long id, LightGoalDto lightGoalDto) {
        Goal goal = this.getGoalById(id);
        goal.update(lightGoalDto);
        return this.goalRepository.saveAndFlush(goal);
    }

    public void deleteGoal(long id) {
        this.goalRepository.deleteById(id);
        return;
    }
}
