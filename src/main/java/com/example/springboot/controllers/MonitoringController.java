package com.example.springboot.controllers;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.beans.Profil;
import com.example.springboot.dto.MonitoringDto;
import com.example.springboot.dto.light.LightMonitoringDto;
import com.example.springboot.mappers.MonitoringMapper;
import com.example.springboot.services.ServiceMonitoring;
import com.example.springboot.services.ServiceProfil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/monitoring" )
public class MonitoringController {
    private final ServiceMonitoring serviceMonitoring;
    private final ServiceProfil serviceProfil;
    public MonitoringController(ServiceMonitoring serviceMonitoring, ServiceProfil serviceProfil){
        this.serviceMonitoring = serviceMonitoring;
        this.serviceProfil = serviceProfil;
    }

    @GetMapping(value = "/{profilId}")
    public ResponseEntity<List<MonitoringDto>> findMonitoringsByProfilId(@PathVariable("profilId") long profilId){
        List<Monitoring> monitoringList = this.serviceMonitoring.getMonitoringByProfilId(profilId);
        List<MonitoringDto> dtos = MonitoringMapper.INSTANCE.toDtoList(monitoringList);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<MonitoringDto> createMonitoring(@RequestBody LightMonitoringDto lightMonitoringDto){
        Monitoring monitoring = MonitoringMapper.INSTANCE.toBo(lightMonitoringDto);
        Profil profil = this.serviceProfil.getProfil(lightMonitoringDto.getProfil_id());
        monitoring.setProfil(profil);
        monitoring = this.serviceMonitoring.addMonitoring(monitoring);
        MonitoringDto monitoringDto = MonitoringMapper.INSTANCE.toDto(monitoring);
        return ResponseEntity.ok(monitoringDto);
    }
}
