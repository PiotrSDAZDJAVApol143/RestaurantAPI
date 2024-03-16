package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.RestaurantReqDto;
import com.example.restaurantapi.dto.RestaurantWriteDto;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
@Validated
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;


    @GetMapping("/{id}")
    public ResponseEntity<RestaurantWriteDto> getRestaurant(@PathVariable Long id) {
        RestaurantWriteDto restaurant = restaurantService.findById(id);
        return ResponseEntity.ok(restaurant);
    }



    @PostMapping("/add")
    public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody RestaurantReqDto requestDto) {
        Restaurant restaurant = restaurantService.buildRestaurant(requestDto);
        restaurant = restaurantService.findOrCreateRestaurant(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @Valid @RequestBody Restaurant request) {
        Restaurant updateRestaurant = restaurantService.updateRestaurant(id, request);
        return ResponseEntity.ok(updateRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }


}
