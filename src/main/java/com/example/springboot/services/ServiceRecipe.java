package com.example.springboot.services;

import com.example.springboot.beans.Recipe;
import com.example.springboot.dto.light.LightRecipeDto;
import com.example.springboot.enums.ERecipeCategory;
import com.example.springboot.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service()
public class ServiceRecipe implements IServiceRecipe {

    private final RecipeRepository recipeRepository;
    public ServiceRecipe(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public Recipe getRecipeById(final UUID id) {
        return this.recipeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No entity found for " + id));
    }

    public List<Recipe> getRecipesByUserId(final UUID id) {
        return this.recipeRepository.getRecipeByUserId(id);
    }

    public Recipe addRecipe(Recipe preceipe) {
        return this.recipeRepository.saveAndFlush(preceipe);
    }

    public Recipe updateRecipe(UUID id, LightRecipeDto lightRecipeDto) {
        Recipe recipe = this.getRecipeById(id);
        recipe.update(lightRecipeDto);
        return this.recipeRepository.saveAndFlush(recipe);
    }

    public void deleteRecipe(UUID id) {
        this.recipeRepository.deleteById(id);
    }

    public List<Recipe> getRecipeByCat(final UUID userId, final ERecipeCategory category) {
        return this.recipeRepository.getRecipeByCategory(userId, category);
    }

    @Override
    public List<Recipe> getRecipeBetweenDate(final UUID userId, final LocalDate dateStart, final LocalDate dateEnd) {
        return this.recipeRepository.getRecipeBetweenDate(userId, dateStart, dateEnd);
    }

    @Override
    public List<Recipe> getRecipeByDate(final UUID userId, LocalDate dateStart) {
        return this.recipeRepository.getRecipeByDate(userId, dateStart);
    }

}
