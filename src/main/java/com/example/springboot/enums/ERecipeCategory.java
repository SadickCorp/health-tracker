package com.example.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ERecipeCategory {
    BREAKFAST("BF"),
    LUNCH("L"),
    DINER("DINER"),
    NIBBLE("N"),
    RECIPE("R");

    private final String code;
}
