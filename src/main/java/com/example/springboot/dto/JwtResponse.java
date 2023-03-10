package com.example.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {
    private final String jwt;
}
