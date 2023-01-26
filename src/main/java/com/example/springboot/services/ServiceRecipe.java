package com.example.springboot.services;

import com.example.springboot.beans.Recipe;
import com.example.springboot.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service()
public class ServiceRecipe implements IServiceRecipe {

    private RecipeRepository repository;
    public ServiceRecipe(RecipeRepository recipeRepository){
        this.repository = recipeRepository;
    }

    public List<Recipe> getRecipes() {

        return this.repository.findAll();
    }

    public Recipe geRecipeById(long id) {

        return this.repository.findById(id).orElseThrow(() -> new NoSuchElementException("No entity found for " + id));
    }

    public void addRecipe(Recipe preceipe) {
        this.repository.saveAndFlush(preceipe);
    }

    public void updateRecipe(Recipe precipe) {
        this.repository.saveAndFlush(precipe);
    }

    public void deleteRecipe(long id) {
        this.repository.deleteById(id);
    }

    public List<Recipe> getRecipeFavorite() {
        return null;
    }

    public List<Recipe> getRecipeByDate(Date dateStart, Date dateEnd) {
        return null;
    }
}
