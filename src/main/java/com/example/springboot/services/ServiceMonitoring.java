package com.example.springboot.services;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.dto.MonitoringDto;
import com.example.springboot.mappers.MonitoringMapper;
import com.example.springboot.repository.MonitoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service()
@RequiredArgsConstructor
public class ServiceMonitoring implements IServiceMonitoring{

    private final MonitoringRepository monitoringRepository;

    public List<MonitoringDto> getMonitoringByUserId(UUID id) {
        return MonitoringMapper.INSTANCE.toDtoList(
                this.monitoringRepository.getMonitoringByIdUser(id)
        );
    }

    public Monitoring addMonitoring(Monitoring monitoring) {
        return this.monitoringRepository.save(monitoring);
    }

}
