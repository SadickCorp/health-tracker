package com.example.springboot.services;

import com.example.springboot.beans.Goal;
import com.example.springboot.beans.Monitoring;
import com.example.springboot.beans.User;
import com.example.springboot.dto.GoalDto;
import com.example.springboot.dto.light.LightGoalDto;
import com.example.springboot.mappers.GoalMapper;
import com.example.springboot.repository.GoalRepository;
import com.example.springboot.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ServiceGoal implements IServiceGoal {

    private final GoalRepository goalRepository;
    private final ServiceUser serviceUser;
    private final ServiceMonitoring serviceMonitoring;
    private final JwtProvider tokenProvider;

    public GoalDto getGoalByUserId(UUID id, String token) {
        if(!tokenProvider.isUserToken(id, token)) {
            throw new IllegalArgumentException("Impossible d'accèder a cette ressource: Id invalide}");
        }
        return  GoalMapper.INSTANCE.toDto(
                this.goalRepository.getGoalByUserId(id)
        );
    }

    public GoalDto addGoal(LightGoalDto dto) {
        Goal goal = GoalMapper.INSTANCE.toBo(dto);
        User user = this.serviceUser.getUserById(dto.getUser_id());
        goal.setUser(user);
        goal = this.goalRepository.save(goal);
        Monitoring monitoring = new Monitoring();
        monitoring.setWeight(dto.getActual_weight());
        monitoring.setUser(this.serviceUser.getUserById(user.getId()));
        this.serviceMonitoring.addMonitoring(monitoring);
        return GoalMapper.INSTANCE.toDto(goal);
    }

    public GoalDto updateGoal(UUID id, LightGoalDto lightGoalDto, String token) {
        if(!tokenProvider.isUserToken(id, token)) {
            throw new IllegalArgumentException("Impossible d'accèder a cette ressource: Id invalide}");
        }
        Goal goal = this.goalRepository.getGoalByUserId(id);
        if(goal.getActual_weight() != lightGoalDto.getActual_weight()){
            Monitoring monitoring = new Monitoring();
            monitoring.setWeight(lightGoalDto.getActual_weight());
            monitoring.setUser(this.serviceUser.getUserById(id));
            this.serviceMonitoring.addMonitoring(monitoring);
        }
        goal.update(lightGoalDto);
        return GoalMapper.INSTANCE.toDto(this.goalRepository.save(goal));
    }

}
