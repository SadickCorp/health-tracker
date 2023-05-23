package com.example.springboot.dto.light;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class LightGoalDto {
    private double actual_weight;
    private double goal_weight;
    private double start_weight;
    private UUID user_id;
}
