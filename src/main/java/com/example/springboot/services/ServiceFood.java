package com.example.springboot.services;

import com.example.springboot.beans.Food;
import com.example.springboot.dto.light.LightFoodDto;
import com.example.springboot.repository.FoodRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service()
public class ServiceFood implements IServiceFood{

    private final FoodRepository foodRepository;

    public ServiceFood(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }


    public List<Food> getFoodByReceipe(long receipe_id){
            return foodRepository.getFoodByRecipeId(receipe_id);
    }

    public Food getFoodById(long id) {
        return this.foodRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No entity found for " + id));
    }

    public Food createFood(Food pfood) {
        return this.foodRepository.saveAndFlush(pfood);
    }

    public Food updateFood(long id, LightFoodDto dto) {
        Food food = this.getFoodById(id);
        food.update(dto);
        return this.foodRepository.saveAndFlush(food);
    }

    public void deleteFood(long id) {
        this.foodRepository.deleteById(id);
    }
}
