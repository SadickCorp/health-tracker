package com.example.springboot.dto.light;

import com.example.springboot.enums.ERecipeCategory;
import com.example.springboot.enums.ERecipeType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class LightRecipeDto {
    private String label;
    private LocalDate date;
    private ERecipeType type;
    private ERecipeCategory category;
    private Boolean is_favorite;
    private UUID user_id;
}
