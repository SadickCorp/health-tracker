package com.example.springboot.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.UUID;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foodcomposition")
public class FoodComposition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

//    @Column(name = "glucides")
//    private double glucides;
//
//    @Column(name = "lipides")
//    private double lipides;
//
//    @Column(name = "proteins")
//    private double proteins;
//
//    @Column(name = "sugar")
//    private double sugar;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private double calories;

    @Column(name = "serving_size_g")
    private double serving_size_g;

    @Column(name = "fat_total_g")
    private double fat_total_g;

    @Column(name = "fat_saturated_g")
    private double fat_saturated_g;

    @Column(name = "protein_g")
    private double protein_g;

    @Column(name = "sodium_mg")
    private double sodium_mg;

    @Column(name = "potassium_mg")
    private double potassium_mg;

    @Column(name = "cholesterol_mg")
    private double cholesterol_mg;

    @Column(name = "carbohydrates_total_g")
    private double carbohydrates_total_g;

    @Column(name = "fiber_g")
    private double fiber_g;

    @Column(name = "sugar_g")
    private double sugar_g;

}
