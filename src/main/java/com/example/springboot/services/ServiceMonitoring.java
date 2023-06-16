package com.example.springboot.services;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.dto.MonitoringDto;
import com.example.springboot.mappers.MonitoringMapper;
import com.example.springboot.repository.MonitoringRepository;
import com.example.springboot.security.JwtProvider;
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
    private final JwtProvider tokenProvider;

    public List<MonitoringDto> getMonitoringByUserId(UUID id, String token) {
        if(tokenProvider.isUserToken(id, token)){
            return MonitoringMapper.INSTANCE.toDtoList(
                    this.monitoringRepository.getMonitoringByIdUser(id)
            );
        }else {
            throw new IllegalArgumentException("Impossible d'accèder a cette ressource: Id invalide");
        }

    }

    public Monitoring addMonitoring(Monitoring monitoring) {
        return this.monitoringRepository.save(monitoring);
    }

}
