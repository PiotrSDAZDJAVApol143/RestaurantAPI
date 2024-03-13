package com.example.restaurantapi.service;

import com.example.restaurantapi.model.RestaurantTable;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.RestaurantTableRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantService restaurantService;

    public RestaurantTable updateCapacityOfTableById(Long id, Integer capacityOfTable) {
        Optional<RestaurantTable> optionalRestaurantTable = restaurantTableRepository.findById(id);
        if (optionalRestaurantTable.isEmpty()) {
            throw new EntityNotFoundException("Table with" + id +" not found");
        }

        RestaurantTable restaurantTable = optionalRestaurantTable.get();
        restaurantTable.setCapacityOfTable(capacityOfTable);
        return restaurantTableRepository.save(restaurantTable);
    }

    public void deleteRestaurantTable(Long id) {
        if(!restaurantTableRepository.existsById(id)){
            throw new EntityNotFoundException("Table with" + id +" not found");
        }
        restaurantTableRepository.deleteById(id);
    }


    public RestaurantTable saveRestaurantTable(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }
}
