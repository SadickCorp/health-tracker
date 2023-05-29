package com.example.springboot.controllers;

import com.example.springboot.beans.Goal;
import com.example.springboot.beans.User;
import com.example.springboot.dto.GoalDto;
import com.example.springboot.dto.light.LightGoalDto;
import com.example.springboot.mappers.GoalMapper;
import com.example.springboot.services.ServiceGoal;
import com.example.springboot.services.ServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping(path = "/api/goal" )
@RequiredArgsConstructor
public class GoalController {

    private final ServiceGoal serviceGoal;
    private final ServiceUser serviceUser;

    @PostMapping
    public ResponseEntity<GoalDto> create(@RequestBody LightGoalDto dto){
        Goal goal = GoalMapper.INSTANCE.toBo(dto);
        User user = this.serviceUser.getUserById(dto.getUser_id());
        goal.setUser(user);
        goal = this.serviceGoal.addGoal(goal);
        GoalDto goalDto = GoalMapper.INSTANCE.toDto(goal);
        return ResponseEntity.ok(goalDto);
    }

    @GetMapping(value = "/{profilId}")
    public ResponseEntity<GoalDto> findGoalByProfilId(@PathVariable("profilId") UUID idProfil){
        Goal goal = this.serviceGoal.getGoalByUserId(idProfil);
        GoalDto dto = GoalMapper.INSTANCE.toDto(goal);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<GoalDto> updateGoal(@PathVariable("id") UUID id, @RequestBody LightGoalDto lightGoalDto){
        Goal update = this.serviceGoal.updateGoal(id, lightGoalDto);
        GoalDto goalDto = GoalMapper.INSTANCE.toDto(update);
        return ResponseEntity.ok(goalDto);
    }
}
