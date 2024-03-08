package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Getter
@Table(name = "FOOD_TYPE")
public enum FoodType {
    ITALIAN("Italian"),
    CHINESE("Chinese"),
    MEXICAN("Mexican"),
    JAPANESE("Japanese"),
    INDIAN("Indian"),
    AMERICAN("American"),
    FRENCH("French"),
    THAI("THAI"),
    POLISH("Polish"),
    GREEK("Greek"),
    SPANISH("Spanish"),
    TURKISH("Turkish"),
    KOREAN("Korean"),
    OTHER("Other");

    private final String displayName;

    FoodType(String displayName) {
        this.displayName = displayName;
    }
}
