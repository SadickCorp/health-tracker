package com.example.springboot.controllers;

import com.example.springboot.dto.ApiFoodCompositionDto;
import com.example.springboot.dto.ApiFoodNameDto;
import com.example.springboot.services.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class ApiController {

    private ApiService apiService;

    @GetMapping()
    public ResponseEntity<ApiFoodCompositionDto> searchFoodComposition(@RequestBody ApiFoodNameDto foodName) throws JSONException, IOException, InterruptedException {

        ApiFoodCompositionDto data = this.apiService.searchFoodComposition(foodName.getFoodName());

        return ResponseEntity.ok(data);
    }

}
