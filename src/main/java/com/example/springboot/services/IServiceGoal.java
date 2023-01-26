package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.dto.light.LightGoalDto;

public interface IServiceGoal {
    public Goal getGoalById(final long id);
    public Goal getGoalByProfilId(final long id);
    public Goal addGoal(final Goal pgoal);
    public Goal updateGoal(final long id, final LightGoalDto lightGoalDto);
    public void deleteGoal(final long id);
}
