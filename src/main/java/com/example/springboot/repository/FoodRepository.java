package com.example.springboot.repository;

import com.example.springboot.beans.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {
    @Query("select f from Food f where f.recipe.id = ?1")
    List<Food> getFoodByRecipeId(UUID recipeId);
}