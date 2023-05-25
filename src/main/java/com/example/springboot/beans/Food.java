package com.example.springboot.beans;

import com.example.springboot.dto.light.LightFoodDto;
import com.example.springboot.enums.EFoodFamily;
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
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private double weight;

    @Column(name = "calorie")
    private double calorie;

    @Column(name = "quantity")
    private double quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "family")
    private EFoodFamily family;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foodcomposition_id", referencedColumnName = "id")
    private FoodComposition foodComposition;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public void update(LightFoodDto lightFoodDto){
        this.setWeight(lightFoodDto.getWeight() != null ? lightFoodDto.getWeight(): this.getWeight());
        this.setQuantity(lightFoodDto.getQuantity() != null ? lightFoodDto.getQuantity() : this.getQuantity());
        this.setCalorie(lightFoodDto.getCalorie() != null ? lightFoodDto.getCalorie() : this.getCalorie());
    }
}
