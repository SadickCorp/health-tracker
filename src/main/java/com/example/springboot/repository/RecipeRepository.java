package com.example.springboot.repository;

import com.example.springboot.beans.Recipe;
import com.example.springboot.enums.ERecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r from Recipe r where r.profil.id = ?1")
    public List<Recipe> getRecipeByProfilId(long profilId);
    @Query("SELECT r from Recipe r where r.profil.id = ?1 and r.category = ?2")
    public List<Recipe> getRecipeByCategory(long profilId, ERecipeCategory recipeCategory);

    @Query("SELECT r from Recipe r where r.profil.id = ?1 and r.date = ?2")
    public List<Recipe> getRecipeByDate(long profilId, LocalDate date);

    @Query("SELECT r from Recipe r where r.profil.id = ?1 and r.date >= ?2 and r.date <= ?3")
    public List<Recipe> getRecipeBetweenDate(long profilId, LocalDate dateStart, LocalDate dateEnd);
}