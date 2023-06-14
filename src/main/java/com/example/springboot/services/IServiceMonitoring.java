package com.example.springboot.services;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.dto.MonitoringDto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface IServiceMonitoring {
    public List<MonitoringDto> getMonitoringByUserId(final UUID id, final String token) throws IllegalAccessException;
    public Monitoring addMonitoring(final Monitoring monitoring);
}
