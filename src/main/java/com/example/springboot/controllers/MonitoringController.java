package com.example.springboot.controllers;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.beans.User;
import com.example.springboot.dto.MonitoringDto;
import com.example.springboot.dto.light.LightMonitoringDto;
import com.example.springboot.mappers.MonitoringMapper;
import com.example.springboot.services.ServiceMonitoring;
import com.example.springboot.services.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping(path = "/api/monitoring" )
@RequiredArgsConstructor
public class MonitoringController {
    private final ServiceMonitoring serviceMonitoring;
    private final ServiceUser serviceUser;


    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<MonitoringDto>> findMonitoringsByUserId(@PathVariable("userId") UUID profilId){
        List<Monitoring> monitoringList = this.serviceMonitoring.getMonitoringByUserId(profilId);
        List<MonitoringDto> dtos = MonitoringMapper.INSTANCE.toDtoList(monitoringList);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<MonitoringDto> createMonitoring(@RequestBody LightMonitoringDto lightMonitoringDto){
        Monitoring monitoring = MonitoringMapper.INSTANCE.toBo(lightMonitoringDto);
        User user = this.serviceUser.getUserById(lightMonitoringDto.getUser_id());
        monitoring.setUser(user);
        monitoring = this.serviceMonitoring.addMonitoring(monitoring);
        MonitoringDto monitoringDto = MonitoringMapper.INSTANCE.toDto(monitoring);
        return ResponseEntity.ok(monitoringDto);
    }
}
