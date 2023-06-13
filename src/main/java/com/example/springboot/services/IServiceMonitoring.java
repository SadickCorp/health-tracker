package com.example.springboot.services;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.dto.MonitoringDto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface IServiceMonitoring {
    public List<MonitoringDto> getMonitoringByUserId(final UUID id);
//    public Monitoring getMonitoringById(final UUID id);
//    public List<Monitoring> getMonitoringByDate(Date dateStart, Date dateEnd);
    public Monitoring addMonitoring(final Monitoring monitoring);
//    public Monitoring updateMonitoring(final Monitoring monitoring);
//    public void deleteMonitoring(final UUID id);
}
