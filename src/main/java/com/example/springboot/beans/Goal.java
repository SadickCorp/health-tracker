package com.example.springboot.beans;
import com.example.springboot.dto.light.LightGoalDto;
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

    public void update(LightGoalDto lightGoalDto){
        this.setGoal_weight(lightGoalDto.getGoal_weight()!= 0.0d ? lightGoalDto.getGoal_weight() : this.getGoal_weight());
        this.setActual_weight(lightGoalDto.getActual_weight()!= 0.0d ? lightGoalDto.getActual_weight() : this.getActual_weight());
        this.setStart_weight(lightGoalDto.getStart_weight()!= 0.0d ? lightGoalDto.getStart_weight() : this.getStart_weight());
    }
}
