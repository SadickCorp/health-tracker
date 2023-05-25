package com.example.springboot.dto;

import com.example.springboot.enums.EFoodFamily;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.example.springboot.beans.Food} entity
 */
@Data
public class FoodDto implements Serializable {
    private final UUID id;
    private final String name;
    private final double weight;
    private final double calorie;
    private final double quantity;
    private final EFoodFamily family;
    private final UUID recipe_id;
}