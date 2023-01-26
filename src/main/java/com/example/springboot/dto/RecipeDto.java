package com.example.springboot.dto;

import com.example.springboot.beans.Recipe;
import com.example.springboot.enums.ERecipeCategory;
import com.example.springboot.enums.ERecipeType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Recipe} entity
 */
@Data
public class RecipeDto implements Serializable {
    private final Long id;
    private final String label;
    private final Date date;
    private final ERecipeType type;
    private final ERecipeCategory category;
    private final Boolean is_favorite;
    private final FoodDto food;
}