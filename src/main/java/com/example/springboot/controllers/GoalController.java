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

    @PostMapping
    public ResponseEntity<GoalDto> create(@RequestBody LightGoalDto dto){
        return ResponseEntity
                .ok()
                .body(this.serviceGoal.addGoal(dto));
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<GoalDto> findGoalByProfilId(@PathVariable("userId") UUID idUser){

        return ResponseEntity
                .ok()
                .body(this.serviceGoal.getGoalByUserId(idUser));
    }

    @PatchMapping(value="/{userId}")
    public ResponseEntity<GoalDto> updateGoal(@PathVariable("userId") UUID id, @RequestBody LightGoalDto lightGoalDto){
        return ResponseEntity
                .ok()
                .body(this.serviceGoal.updateGoal(id, lightGoalDto));
    }
}
