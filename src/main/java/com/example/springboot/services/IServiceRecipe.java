package com.example.springboot.services;

import com.example.springboot.beans.Recipe;
import com.example.springboot.dto.light.LightRecipeDto;
import com.example.springboot.enums.ERecipeCategory;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface IServiceRecipe {
    public Recipe getRecipeById(final UUID id);
    public List<Recipe> getRecipesByUserId(final UUID userId);
    public Recipe addRecipe(final Recipe preceipe);
    public Recipe updateRecipe(final UUID id, final LightRecipeDto lightRecipeDto);
    public void deleteRecipe(final UUID id);
    public List<Recipe> getRecipeByCat(final UUID profilId, final ERecipeCategory category);
    public List<Recipe> getRecipeBetweenDate(final UUID profilId, final LocalDate dateStart, final LocalDate dateEnd);
    public List<Recipe> getRecipeByDate(final UUID profilId, final LocalDate dateStart);

}
