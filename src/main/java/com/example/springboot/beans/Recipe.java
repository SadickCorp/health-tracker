package com.example.springboot.beans;

import com.example.springboot.dto.light.LightRecipeDto;
import com.example.springboot.enums.ERecipeCategory;
import com.example.springboot.enums.ERecipeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity()
@Setter
@Getter
@AllArgsConstructor
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "label")
    private String label;

    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ERecipeType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ERecipeCategory category;

    @Column(name = "is_favorite")
    private Boolean is_favorite;

    @OneToMany(mappedBy = "recipe")
    private List<Food> foods;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Recipe(){
        this.setDate(LocalDate.now());
    }

    public void update(LightRecipeDto lightRecipeDto){
        this.setLabel(lightRecipeDto.getLabel() != null ? lightRecipeDto.getLabel() : this.getLabel());
        this.setType(lightRecipeDto.getType() != null ? lightRecipeDto.getType() : this.getType());
        this.setCategory(lightRecipeDto.getCategory() != null ? lightRecipeDto.getCategory() : this.getCategory());

    }
}
