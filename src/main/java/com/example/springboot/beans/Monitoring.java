package com.example.springboot.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@Table(name = "monitoring")
public class Monitoring {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight")
    private double weight;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "profil_id")
    private Profil profil;

    public Monitoring(){
        this.setDate(LocalDate.now());
    }
}
