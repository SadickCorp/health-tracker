package com.example.springboot.services;

import com.example.springboot.beans.Recipe;
import com.example.springboot.dto.light.LightRecipeDto;
import com.example.springboot.enums.ERecipeCategory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IServiceRecipe {
    public Recipe getRecipeById(final long id);
    public List<Recipe> geRecipesByProfilId(final long profilId);
    public Recipe addRecipe(final Recipe preceipe);
    public Recipe updateRecipe(final long id, final LightRecipeDto lightRecipeDto);
    public void deleteRecipe(final long id);
    public List<Recipe> getRecipeByCat(final long profilId, final ERecipeCategory category);
    public List<Recipe> getRecipeBetweenDate(final long profilId, final LocalDate dateStart, final LocalDate dateEnd);
    public List<Recipe> getRecipeByDate(final long profilId, final LocalDate dateStart);

}
