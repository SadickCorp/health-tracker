package com.example.springboot.beans;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "actual_weight")
    private double actual_weight;

    @Column(name = "goal_weight")
    private double goal_weight;

    @Column(name = "start_weight")
    private double start_weight;

    @OneToOne
    private Profil profil;
}
