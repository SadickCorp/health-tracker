package com.example.springboot.mappers;

import com.example.springboot.beans.Food;
import com.example.springboot.dto.FoodDto;
import com.example.springboot.dto.light.LightFoodDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    @Mapping(target = "id", ignore = true)
    Food toBo(LightFoodDto dto);

    FoodDto toDto(Food bo);

    List<FoodDto> toDtoList(List<Food> bo);

}
