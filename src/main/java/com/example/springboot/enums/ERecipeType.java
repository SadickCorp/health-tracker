package com.example.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ERecipeType {
    NONE("NONE"),
    VEGAN("VEGAN"),
    VEGE("VEGE"),
    GLUTENFREE("GLUTENFREE"),
    LACTOSEFREE("LACTOSEFREE");
    private final String code;

}
