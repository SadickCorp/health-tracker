package com.example.springboot.controllers;

import com.example.springboot.beans.Food;
import com.example.springboot.dto.FoodDto;
import com.example.springboot.mappers.FoodMapper;
import com.example.springboot.services.ServiceFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/foods" )
public class FoodController {


    public final ServiceFood serviceFood;

    public FoodController(ServiceFood serviceFood){
        this.serviceFood = serviceFood;
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
}
