package com.example.springboot.services;

import com.example.springboot.beans.Recipe;

import java.util.Date;
import java.util.List;

public interface IServiceRecipe {
    public List<Recipe> getRecipes();
    public Recipe geRecipeById(final long id);
    public void addRecipe(final Recipe preceipe);
    public void updateRecipe(final Recipe preceipe);
    public void deleteRecipe(final long id);
    public List<Recipe> getRecipeFavorite();
    public List<Recipe> getRecipeByDate(Date dateStart, Date dateEnd);

}
