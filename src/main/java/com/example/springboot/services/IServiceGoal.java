package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.dto.GoalDto;
import com.example.springboot.dto.light.LightGoalDto;

import java.util.UUID;

public interface IServiceGoal {
//    public GoalDto getGoalById(final UUID id);
    public GoalDto getGoalByUserId(final UUID id);
    public GoalDto addGoal(final LightGoalDto dto);
    public GoalDto updateGoal(final UUID id, final LightGoalDto lightGoalDto);
//    public void deleteGoal(final UUID id);
}
