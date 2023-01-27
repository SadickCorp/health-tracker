package com.example.springboot.controllers;

import com.example.springboot.beans.Profil;
import com.example.springboot.beans.Recipe;
import com.example.springboot.dto.RecipeDto;
import com.example.springboot.dto.light.LightMonitoringDto;
import com.example.springboot.dto.light.LightRecipeDto;
import com.example.springboot.enums.ERecipeCategory;
import com.example.springboot.mappers.RecipeMapper;
import com.example.springboot.services.ServiceProfil;
import com.example.springboot.services.ServiceRecipe;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "recipes" )
public class RecipeController {
    private final ServiceRecipe serviceRecipe;
    private final ServiceProfil serviceProfil;

    public RecipeController(ServiceRecipe serviceRecipe, ServiceProfil serviceProfil){
        this.serviceRecipe = serviceRecipe;
        this.serviceProfil = serviceProfil;
    }
    @GetMapping("/{profilId}")
    public ResponseEntity<List<RecipeDto>> getRecipesByProfilId(@PathVariable("profilId") long profilId){
        List<Recipe> recipeList = this.serviceRecipe.geRecipesByProfilId(profilId);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{profilId}", params = {"date"})
    public ResponseEntity<List<RecipeDto>> getRecipesByDate(@PathVariable("profilId") long profilId,
                                                            @RequestParam("date")LocalDate date){
        List<Recipe> recipeList = this.serviceRecipe.getRecipeByDate(profilId, date);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{profilId}", params = {"startDate", "endDate"})
    public ResponseEntity<List<RecipeDto>> getRecipesbetweenDate(@PathVariable("profilId") long profilId,
                                                                 @RequestParam("startDate") LocalDate startDate,
                                                                 @RequestParam("endDate") LocalDate endDate){
        List<Recipe> recipeList = this.serviceRecipe.getRecipeBetweenDate(profilId, startDate, endDate);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{profilId}", params = {"cat"})
    public ResponseEntity<List<RecipeDto>> getRecipesByCategory(@PathVariable("profilId") long profilId,
                                                                @RequestParam("cat")ERecipeCategory category){
        List<Recipe> recipeList = this.serviceRecipe.getRecipeByCat(profilId, category);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    //TODO get par categorie et date

    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody LightRecipeDto lightRecipeDto){
        Recipe recipe = RecipeMapper.INSTANCE.toBo(lightRecipeDto);
        Profil profil = this.serviceProfil.getProfil(lightRecipeDto.getProfil_id());
        recipe.setProfil(profil);
        recipe = this.serviceRecipe.addRecipe(recipe);
        RecipeDto dto = RecipeMapper.INSTANCE.toDto(recipe);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable("id") long id, @RequestBody LightRecipeDto lightRecipeDto){
        Recipe update = this.serviceRecipe.updateRecipe(id, lightRecipeDto);
        RecipeDto recipeDto = RecipeMapper.INSTANCE.toDto(update);
        return ResponseEntity.ok(recipeDto);
    }

}
