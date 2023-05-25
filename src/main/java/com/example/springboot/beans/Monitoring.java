package com.example.springboot.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@Table(name = "monitoring")
public class Monitoring {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "weight")
    private double weight;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Monitoring(){
        this.setDate(LocalDate.now());
    }
}
