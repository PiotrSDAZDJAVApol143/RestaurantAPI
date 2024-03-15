package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Getter;



@Getter
@Table(name = "FOOD_TYPE")
public enum FoodType {
    ITALIAN,
    CHINESE,
    MEXICAN,
    JAPANESE,
    INDIAN,
    AMERICAN,
    FRENCH,
    THAI,
    POLISH,
    GREEK,
    SPANISH,
    TURKISH,
    KOREAN,
    FASTFOOD;
}
