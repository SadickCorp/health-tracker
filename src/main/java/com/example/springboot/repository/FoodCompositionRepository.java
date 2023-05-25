package com.example.springboot.repository;

import com.example.springboot.beans.FoodComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodCompositionRepository extends JpaRepository<FoodComposition, UUID> {
}