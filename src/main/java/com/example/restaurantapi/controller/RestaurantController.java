package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.RestaurantReqDto;
import com.example.restaurantapi.dto.RestaurantWriteDto;
import com.example.restaurantapi.dto.ReviewDto;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.Review;
import com.example.restaurantapi.service.RestaurantService;
import com.example.restaurantapi.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
@Validated
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final ReviewService reviewService;


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


    @PatchMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @Valid @RequestBody RestaurantReqDto requestDto) {
        Restaurant updateRestaurant = restaurantService.updateRestaurant(id, requestDto);
        return ResponseEntity.ok(updateRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/review/add")
    public ResponseEntity<Review> createNewReview(@PathVariable Long id, @Valid @RequestBody ReviewDto reviewDto) {
        Review review = reviewService.createReview(id, reviewDto);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }


}
