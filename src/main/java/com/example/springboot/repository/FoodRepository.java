package com.example.springboot.repository;

import com.example.springboot.beans.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query("select f from Food f where f.recipe.id = ?1")
    List<Food> getFoodByRecipeId(long recipeId);
}