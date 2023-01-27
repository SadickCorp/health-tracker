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

@Service()
public class ServiceRecipe implements IServiceRecipe {

    private final RecipeRepository recipeRepository;
    public ServiceRecipe(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public Recipe getRecipeById(final long id) {
        return this.recipeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No entity found for " + id));
    }

    public List<Recipe> geRecipesByProfilId(final long id) {
        return this.recipeRepository.getRecipeByProfilId(id);
    }

    public Recipe addRecipe(Recipe preceipe) {
        return this.recipeRepository.saveAndFlush(preceipe);
    }

    public Recipe updateRecipe(long id, LightRecipeDto lightRecipeDto) {
        Recipe recipe = this.getRecipeById(id);
        recipe.update(lightRecipeDto);
        return this.recipeRepository.saveAndFlush(recipe);
    }

    public void deleteRecipe(long id) {
        this.recipeRepository.deleteById(id);
    }

    public List<Recipe> getRecipeByCat(final long profilId, final ERecipeCategory category) {
        return this.recipeRepository.getRecipeByCategory(profilId, category);
    }

    @Override
    public List<Recipe> getRecipeBetweenDate(final long profilId, final LocalDate dateStart, final LocalDate dateEnd) {
        return this.recipeRepository.getRecipeBetweenDate(profilId, dateStart, dateEnd);
    }

    @Override
    public List<Recipe> getRecipeByDate(final long profilId, LocalDate dateStart) {
        return this.recipeRepository.getRecipeByDate(profilId, dateStart);
    }

}
