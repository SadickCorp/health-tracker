package com.example.springboot.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.springboot.beans.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final UUID id;
    private final String email;
    private final String password;
    private final List<MonitoringDto> monitorings;
    private final List<RecipeDto> recipes;
    private final GoalDto goal;
}