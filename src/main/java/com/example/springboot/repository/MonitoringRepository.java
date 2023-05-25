package com.example.springboot.repository;

import com.example.springboot.beans.Monitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, UUID> {

    @Query("SELECT m from Monitoring m where m.user.id = ?1")
    List<Monitoring> getMonitoringByIdProfil(final UUID profilId);
}