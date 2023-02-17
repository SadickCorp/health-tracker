package com.example.springboot.dto.light;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LightGoalDto {
    private double actual_weight;
    private double goal_weight;
    private double start_weight;
    private Long profil_id;
}
