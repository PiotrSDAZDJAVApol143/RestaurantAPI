package com.example.restaurantapi.dto;

import com.example.restaurantapi.model.Address;
import com.example.restaurantapi.model.FoodType;
import com.example.restaurantapi.model.ImageEntity;
import com.example.restaurantapi.model.RestaurantTable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class RestaurantReqDto {

    private Long id;
    private String restaurantName;
    private Address addressDto = new Address();
    private LocalTime openingHours;
    private LocalTime closingHours;
    private List<ImageEntity> imagesFromRestaurant;
    private Set<FoodType> foodTypes;
    private List<RestaurantTable> tables;
}
