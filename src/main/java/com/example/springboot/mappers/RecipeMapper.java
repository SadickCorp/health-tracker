package com.example.springboot.mappers;

import com.example.springboot.beans.Recipe;
import com.example.springboot.dto.RecipeDto;
import com.example.springboot.dto.light.LightRecipeDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    @Mapping(target = "food", ignore = true)
    @Mapping(target = "profil", ignore = true)
    @Mapping(target = "date", ignore = true)
    Recipe toBo(LightRecipeDto dto);

    @Mapping(target = "profil_id", source="profil.id")
    RecipeDto toDto(Recipe bo);

    List<RecipeDto> toDtoList(List<Recipe> bo);
}
