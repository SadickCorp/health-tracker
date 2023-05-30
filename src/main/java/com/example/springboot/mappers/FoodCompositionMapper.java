package com.example.springboot.mappers;

import com.example.springboot.beans.FoodComposition;
import com.example.springboot.dto.ApiFoodCompositionDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface FoodCompositionMapper {
    FoodCompositionMapper INSTANCE = Mappers.getMapper(FoodCompositionMapper.class);

    FoodComposition toBo(ApiFoodCompositionDto dto);

    ApiFoodCompositionDto toDto(FoodComposition foodComposition);
}
