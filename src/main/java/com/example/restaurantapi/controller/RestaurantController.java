package com.example.restaurantapi.controller;

import com.example.restaurantapi.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@Validated
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

}
