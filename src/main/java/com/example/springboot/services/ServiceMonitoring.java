package com.example.springboot.services;

import com.example.springboot.beans.Monitoring;
import com.example.springboot.repository.MonitoringRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service()
public class ServiceMonitoring implements IServiceMonitoring{

    private final MonitoringRepository monitoringRepository;

    public ServiceMonitoring(MonitoringRepository monitoringRepository){
        this.monitoringRepository = monitoringRepository;
    }
    public List<Monitoring> getMonitoringByProfilId(long id) {
        return this.monitoringRepository.getMonitoringByIdProfil(id);
    }


    public Monitoring getMonitoringById(long id) {
        Monitoring monitoring = this.monitoringRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No entity found for " + id));;
        return monitoring;
    }


    public List<Monitoring> getMonitoringByDate(Date dateStart, Date dateEnd) {
        //TODO

        return null;
    }

    public Monitoring addMonitoring(Monitoring monitoring) {
        return this.monitoringRepository.saveAndFlush(monitoring);
    }

    public Monitoring updateMonitoring(Monitoring monitoring) {
         return this.monitoringRepository.saveAndFlush(monitoring);
    }

    public void deleteMonitoring(long id) {
        this.monitoringRepository.deleteById(id);
    }
}
