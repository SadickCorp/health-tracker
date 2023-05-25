package com.example.springboot.mappers;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.dto.MonitoringDto;
import com.example.springboot.dto.light.LightMonitoringDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MonitoringMapper {
    MonitoringMapper INSTANCE = Mappers.getMapper(MonitoringMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "date", ignore = true)
    Monitoring toBo(LightMonitoringDto dto);



    @Mapping(target = "user_id", source = "user.id")
    MonitoringDto toDto(Monitoring bo);

    List<MonitoringDto> toDtoList(List<Monitoring> bo);
}
