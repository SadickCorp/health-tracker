package com.example.springboot.dto.light;

import com.example.springboot.enums.EFoodPreference;
import com.example.springboot.enums.EUserSexe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class LightProfilDto {
    private String name;
    private String surname;
    private double height;
    private EUserSexe sexe;
    private LocalDate birth;
    private double weight;
    private EFoodPreference food_preference;
    private UUID user_id;
}
