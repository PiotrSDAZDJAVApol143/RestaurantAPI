package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.RestaurantReqDto;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@Validated
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;






}
