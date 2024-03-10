package com.example.restaurantapi.service;

import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.RestaurantTableRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;


    public Restaurant createRestaurant(String restaurantName) {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setRestaurantName(restaurantName);
        return restaurantRepository.save(newRestaurant);
    }
    public Restaurant findOrCreateRestaurant(String restaurantName){
        return restaurantRepository.findByRestaurantName(restaurantName)
                .orElseGet(()->createRestaurant(restaurantName));
    }

    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + id));
    }
}
