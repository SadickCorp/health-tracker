package com.example.springboot.services;

import com.example.springboot.beans.FoodComposition;
import com.example.springboot.repository.FoodCompositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service()
public class ServiceFoodComposition implements IServiceFoodComposition{

    private final FoodCompositionRepository repository;

    public ServiceFoodComposition(FoodCompositionRepository repository){
        this.repository = repository;
    }
    public FoodComposition getFoodCompositionById(UUID id) {

        return repository.findById(id).orElse(null);
    }


    public List<FoodComposition> getFoodCompositionByFoodId(UUID id) {
        return null;
    }


    public FoodComposition addFoodComposition(FoodComposition ffoodcomposition) {
        return this.repository.saveAndFlush(ffoodcomposition);
    }


    public FoodComposition updateFoodComposition(FoodComposition ffoodcomposition) {
        return this.repository.saveAndFlush(ffoodcomposition);
    }


    public void deleteFoodComposition(UUID id) {
        this.repository.deleteById(id);
    }
}
