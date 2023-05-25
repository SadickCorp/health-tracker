package com.example.springboot.dto;

import com.example.springboot.beans.Profil;
import com.example.springboot.enums.EFoodPreference;
import com.example.springboot.enums.EUserSexe;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * A DTO for the {@link Profil} entity
 */
@Data
public class ProfilDto implements Serializable {
    private final UUID id;
    private final String name;
    private final String surname;
    private final Integer height;
    private final EUserSexe sexe;
    private final LocalDate created_at;
    private final LocalDate birth;
    private final Integer weight;
    private final EFoodPreference food_preference;
    private final UUID user_id;

}