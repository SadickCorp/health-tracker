package com.example.springboot.services;

import com.example.springboot.beans.Food;
import com.example.springboot.dto.light.LightFoodDto;

import java.util.List;
import java.util.UUID;

public interface IServiceFood {
    public List<Food> getFoodByReceipe(final UUID receipe_id);
    public Food getFoodById(final UUID id);
    public Food createFood(final Food pfood);
    public Food updateFood(final UUID id, final LightFoodDto dto);
    public void deleteFood(final UUID id);

}
