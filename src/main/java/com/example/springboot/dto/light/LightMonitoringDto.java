package com.example.springboot.dto.light;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class LightMonitoringDto {
    private double weight;
    private UUID user_id;
}
