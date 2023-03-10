package com.example.springboot.dto;

import lombok.Data;

@Data
public class ApiFoodCompositionDto {
    private final String name;
    private final double calories;
    private final double serving_size_g;
    private final double fat_total_g;
    private final double fat_saturated_g;
    private final double protein_g;
    private final double sodium_mg;
    private final double potassium_mg;
    private final double cholesterol_mg;
    private final double carbohydrates_total_g;
    private final double fiber_g;
    private final double sugar_g;

}
