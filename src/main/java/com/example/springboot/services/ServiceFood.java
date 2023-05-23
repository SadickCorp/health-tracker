package com.example.springboot.services;

import com.example.springboot.beans.Food;
import com.example.springboot.dto.light.LightFoodDto;
import com.example.springboot.repository.FoodRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service()
public class ServiceFood implements IServiceFood{

    private final FoodRepository foodRepository;

    public ServiceFood(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }


    public List<Food> getFoodByReceipe(UUID receipe_id){
            return foodRepository.getFoodByRecipeId(receipe_id);
    }

    public Food getFoodById(UUID id) {
        return this.foodRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No entity found for " + id));
    }

    public Food createFood(Food pfood) {
        return this.foodRepository.saveAndFlush(pfood);
    }

    public Food updateFood(UUID id, LightFoodDto dto) {
        Food food = this.getFoodById(id);
        food.update(dto);
        return this.foodRepository.saveAndFlush(food);
    }

    public void deleteFood(UUID id) {
        this.foodRepository.deleteById(id);
    }
}
