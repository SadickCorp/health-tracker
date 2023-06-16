package com.example.springboot.services;

import com.example.springboot.dto.ApiFoodCompositionDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiService {

    @Value("${app.caloriesninja.uri}")
    private String uriApi;

    @Value("${app.caloriesninja.apikey}")
    private String keyApi;

    public ApiFoodCompositionDto searchFoodComposition(String foodName) throws IOException, InterruptedException, JSONException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriApi+foodName))
                .headers("X-Api-Key", keyApi)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject documentObj = new JSONObject(response.body());
        JSONArray items = documentObj.getJSONArray("items");
        Gson gson = new Gson();
        return gson.fromJson(String.valueOf(items.get(0)), ApiFoodCompositionDto.class);
    }
}
