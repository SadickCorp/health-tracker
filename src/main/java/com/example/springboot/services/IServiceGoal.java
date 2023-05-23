package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.dto.light.LightGoalDto;

import java.util.UUID;

public interface IServiceGoal {
    public Goal getGoalById(final UUID id);
    public Goal getGoalByProfilId(final UUID id);
    public Goal addGoal(final Goal pgoal);
    public Goal updateGoal(final UUID id, final LightGoalDto lightGoalDto);
    public void deleteGoal(final UUID id);
}
