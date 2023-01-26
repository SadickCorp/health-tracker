package com.example.springboot.controllers;

import com.example.springboot.beans.Recipe;
import com.example.springboot.services.ServiceRecipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/receipes" )
public class RecipeController {
    private ServiceRecipe serviceRecipe;


    public RecipeController(ServiceRecipe serviceRecipe){
        this.serviceRecipe = serviceRecipe;
    }
    @GetMapping
    public List<Recipe> getRecipes( ){
        return serviceRecipe.getRecipes();
    }

}
