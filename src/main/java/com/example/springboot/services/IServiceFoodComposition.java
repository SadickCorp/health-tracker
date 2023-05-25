package com.example.springboot.services;

import com.example.springboot.beans.FoodComposition;

import java.util.List;
import java.util.UUID;

public interface IServiceFoodComposition {
    public FoodComposition getFoodCompositionById(final UUID id);
    public List<FoodComposition> getFoodCompositionByFoodId(final UUID id);
    public FoodComposition addFoodComposition(final FoodComposition ffoodcomposition);
    public FoodComposition updateFoodComposition(final FoodComposition ffoodcomposition);
    public void deleteFoodComposition(final UUID id);
}
