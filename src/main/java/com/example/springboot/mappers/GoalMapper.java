package com.example.springboot.mappers;

import com.example.springboot.beans.Goal;
import com.example.springboot.dto.GoalDto;
import com.example.springboot.dto.light.LightGoalDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GoalMapper {
    GoalMapper INSTANCE = Mappers.getMapper(GoalMapper.class);

    @Mapping(target = "id", ignore = true)
    Goal toBo(LightGoalDto dto);

    @Mapping(target = "profil_id", source = "profil.id")
    GoalDto toDto(Goal bo);
}
