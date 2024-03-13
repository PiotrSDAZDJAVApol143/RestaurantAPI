package com.example.restaurantapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private Long id;
    private String name;
    private String street;
    private String buildingNumber;
    private String localNumber;
    private String city;
    private String zipCode;
    private String country;
}
