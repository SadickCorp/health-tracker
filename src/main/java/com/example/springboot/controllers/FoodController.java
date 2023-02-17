package com.example.springboot.controllers;

import com.example.springboot.beans.Food;
import com.example.springboot.beans.Recipe;
import com.example.springboot.dto.FoodDto;
import com.example.springboot.dto.light.LightFoodDto;
import com.example.springboot.mappers.FoodMapper;
import com.example.springboot.services.ServiceFood;
import com.example.springboot.services.ServiceRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/foods" )
public class FoodController {


    private final ServiceFood serviceFood;
    private final ServiceRecipe serviceRecipe;

    public FoodController(ServiceFood serviceFood, ServiceRecipe serviceRecipe){
        this.serviceFood = serviceFood;
        this.serviceRecipe = serviceRecipe;
    }


    @GetMapping("/{id}")
    public ResponseEntity<FoodDto> findById(@PathVariable("id") Long id){
        Food food = this.serviceFood.getFoodById(id);
        FoodDto dto = FoodMapper.INSTANCE.toDto(food);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(params = {"recipeId"})
    public ResponseEntity<List<FoodDto>> findByRecipeId(@RequestParam("recipeId") Long id){
        List<Food> foods = serviceFood.getFoodByReceipe(id);
        List<FoodDto> dtos = FoodMapper.INSTANCE.toDtoList(foods);
        return ResponseEntity.ok(dtos);

    }

    @PostMapping
    public ResponseEntity<FoodDto> create(@RequestBody LightFoodDto dto){
        Food food = FoodMapper.INSTANCE.toBo(dto);
        Recipe recipe = this.serviceRecipe.getRecipeById(dto.getRecipe_id());
        food.setRecipe(recipe);
        food = this.serviceFood.createFood(food);
        FoodDto foodDto = FoodMapper.INSTANCE.toDto(food);
        return ResponseEntity.ok(foodDto);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<FoodDto> update(@PathVariable("id") long id, @RequestBody LightFoodDto dto){
        Food update = this.serviceFood.updateFood(id, dto);
        FoodDto foodDto = FoodMapper.INSTANCE.toDto(update);
        return ResponseEntity.ok(foodDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        this.serviceFood.deleteFood(id);
        return ResponseEntity.noContent().build();
    }


}
