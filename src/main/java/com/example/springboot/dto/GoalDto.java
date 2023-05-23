package com.example.springboot.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.springboot.beans.Goal} entity
 */
@Data
public class GoalDto implements Serializable {
    private final UUID id;
    private final double actual_weight;
    private final double goal_weight;
    private final double start_weight;
    private final UUID user_id;
}