package com.example.springboot.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A DTO for the {@link com.example.springboot.beans.Monitoring} entity
 */
@Data
public class MonitoringDto implements Serializable {
    private final Long id;
    private final double weight;
    private final LocalDate date;
    private final long profil_id;
}