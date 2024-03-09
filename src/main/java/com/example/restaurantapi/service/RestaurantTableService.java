package com.example.restaurantapi.service;

import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.RestaurantTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;
}
