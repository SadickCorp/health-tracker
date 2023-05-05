package com.example.springboot.services;

import com.example.springboot.dto.ApiFoodCompositionDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    @Test
    void searchFoodCompositionTest() throws JSONException, IOException, InterruptedException {
        String foodName = "milk";
        ApiFoodCompositionDto foodCompositionDto = this.apiService.searchFoodComposition(foodName);
        assertNotNull(foodCompositionDto);
        assertEquals(foodCompositionDto.getName(),foodName);
        assertInstanceOf(ApiFoodCompositionDto.class, foodCompositionDto);
        assertInstanceOf(Double.class, foodCompositionDto.getCalories());
        assertFalse(Double.isNaN(foodCompositionDto.getCalories()));

    }
}
