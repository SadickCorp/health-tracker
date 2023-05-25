package com.example.springboot.repository;

import com.example.springboot.beans.Recipe;
import com.example.springboot.enums.ERecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
    @Query("SELECT r from Recipe r where r.user.id = ?1")
    public List<Recipe> getRecipeByProfilId(UUID profilId);
    @Query("SELECT r from Recipe r where r.user.id = ?1 and r.category = ?2")
    public List<Recipe> getRecipeByCategory(UUID profilId, ERecipeCategory recipeCategory);

    @Query("SELECT r from Recipe r where r.user.id = ?1 and r.date = ?2")
    public List<Recipe> getRecipeByDate(UUID profilId, LocalDate date);

    @Query("SELECT r from Recipe r where r.user.id = ?1 and r.date >= ?2 and r.date <= ?3")
    public List<Recipe> getRecipeBetweenDate(UUID profilId, LocalDate dateStart, LocalDate dateEnd);
}