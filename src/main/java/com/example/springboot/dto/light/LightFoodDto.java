package com.example.springboot.dto.light;

import com.example.springboot.enums.EFoodFamily;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class LightFoodDto {
    private String name;
    private Integer weight;
    private Integer calorie;
    private Integer quantity;
    private EFoodFamily family;
    private UUID recipe_id;
}
