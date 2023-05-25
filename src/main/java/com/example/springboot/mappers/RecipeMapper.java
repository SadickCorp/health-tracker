package com.example.springboot.mappers;

import com.example.springboot.beans.Recipe;
import com.example.springboot.dto.RecipeDto;
import com.example.springboot.dto.light.LightRecipeDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "foods", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "date", ignore = true)
    Recipe toBo(LightRecipeDto dto);

    @Mapping(target = "user_id", source="user.id")
    RecipeDto toDto(Recipe bo);

    List<RecipeDto> toDtoList(List<Recipe> bo);
}
