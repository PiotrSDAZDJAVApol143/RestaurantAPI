package com.example.restaurantapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTableConfigurationDTO {

    @NotBlank(message = "Restaurant Name is required")
    private String restaurantName;
    @NotNull(message = "Number of Tables in Restaurant is required")
    @Min(value = 1, message = "Table Number in Restaurant must be greater than 0")
    private Integer tableNumber;
    @NotNull(message = "Capacity of Tables in Restaurant is required")
    @Min(value = 1, message = "Capacity of Tables in Restaurant must be greater than 0")
    private int capacityPerTable;
}
