package com.example.restaurantapi.dto;

import com.example.restaurantapi.model.Address;
import com.example.restaurantapi.model.FoodType;
import com.example.restaurantapi.model.ImageEntity;
import com.example.restaurantapi.model.RestaurantTable;
import lombok.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder

public class RestaurantWriteDto {

    private Long id;
    private String restaurantName;
    private Address addressDto;
    private LocalTime openingHours;
    private LocalTime closingHours;
    private List<ImageEntity> imagesFromRestaurant;
    private Set<FoodType> foodTypes;
    private List<RestaurantTableDTO> tables;
    private List<ReviewDto> reviews;
}
