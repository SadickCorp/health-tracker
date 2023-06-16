package com.example.springboot.controllers;

import com.example.springboot.beans.Recipe;
import com.example.springboot.beans.User;
import com.example.springboot.dto.RecipeDto;
import com.example.springboot.dto.light.LightRecipeDto;
import com.example.springboot.enums.ERecipeCategory;
import com.example.springboot.mappers.RecipeMapper;
import com.example.springboot.services.ServiceRecipe;
import com.example.springboot.services.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/recipes" )
@RequiredArgsConstructor
public class RecipeController {
    private final ServiceRecipe serviceRecipe;
    private final ServiceUser serviceUser;

    @GetMapping("/{userId}")
    public ResponseEntity<List<RecipeDto>> getRecipesByUserId(@PathVariable("userId") UUID userId){
        List<Recipe> recipeList = this.serviceRecipe.getRecipesByUserId(userId);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{userId}", params = {"date"})
    public ResponseEntity<List<RecipeDto>> getRecipesByDate(@PathVariable("userId") UUID userId,
                                                            @RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        List<Recipe> recipeList = this.serviceRecipe.getRecipeByDate(userId, date);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{userId}", params = {"startDate", "endDate"})
    public ResponseEntity<List<RecipeDto>> getRecipesbetweenDate(@PathVariable("userId") UUID userId,
                                                                 @RequestParam("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
                                                                 @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate){
        List<Recipe> recipeList = this.serviceRecipe.getRecipeBetweenDate(userId, startDate, endDate);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping(value = "/{userId}", params = {"cat"})
    public ResponseEntity<List<RecipeDto>> getRecipesByCategory(@PathVariable("userId") UUID userId,
                                                                @RequestParam("cat")ERecipeCategory category){
        List<Recipe> recipeList = this.serviceRecipe.getRecipeByCat(userId, category);
        List<RecipeDto> dtos = RecipeMapper.INSTANCE.toDtoList(recipeList);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody LightRecipeDto lightRecipeDto){
        Recipe recipe = RecipeMapper.INSTANCE.toBo(lightRecipeDto);
        User user = this.serviceUser.getUserById(lightRecipeDto.getUser_id());
        recipe.setUser(user);
        recipe = this.serviceRecipe.addRecipe(recipe);
        RecipeDto dto = RecipeMapper.INSTANCE.toDto(recipe);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable("id") UUID id, @RequestBody LightRecipeDto lightRecipeDto){
        Recipe update = this.serviceRecipe.updateRecipe(id, lightRecipeDto);
        RecipeDto recipeDto = RecipeMapper.INSTANCE.toDto(update);
        return ResponseEntity.ok(recipeDto);
    }

}
