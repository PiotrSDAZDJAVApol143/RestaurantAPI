package com.example.restaurantapi.service;

import com.example.restaurantapi.dto.RestaurantTableDTO;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.RestaurantTable;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.RestaurantTableRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantTableService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantService restaurantService;

    public RestaurantTable saveRestaurantTable(Long restaurantId, RestaurantTable restaurantTable) {
        Restaurant restaurant = restaurantService.findRestaurantTableById(restaurantId);
        restaurantTable.setRestaurant(restaurant);
        return restaurantTableRepository.save(restaurantTable);
    }



    public void deleteRestaurantTable(Long restaurantId, Long tableId) {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(tableId)
                .orElseThrow(() -> new EntityNotFoundException("Table with id " + tableId + " not found"));
        if (!restaurantTable.getRestaurant().getId().equals(restaurantId)) {
            throw new IllegalArgumentException("Table with id " + tableId + " does not belong to restaurant with id " + restaurantId);
        }
        restaurantTableRepository.deleteById(tableId);
    }

    public List<RestaurantTable> updateTablesInRestaurant(Long restaurantId, List<RestaurantTableDTO> tables) {
        Restaurant restaurant = restaurantService.findRestaurantTableById(restaurantId);
        List<RestaurantTable> updatedTables = new ArrayList<>();
        for (RestaurantTableDTO tableDTO : tables) {
            RestaurantTable table = restaurantTableRepository.findById(tableDTO.getId()).orElse(new RestaurantTable());
            table.setRestaurant(restaurant);
            table.setTableNumber(tableDTO.getTableNumber());
            table.setCapacityOfTable(tableDTO.getCapacityPerTable());
            table.setReservationCheck(tableDTO.getReservationCheck());
            updatedTables.add(restaurantTableRepository.save(table));
        }
        return updatedTables;
    }

    public RestaurantTable buildTable(RestaurantTableDTO request) {
        RestaurantTable restaurantTable = new RestaurantTable();
        Restaurant restaurant = restaurantService.findRestaurantTableById(request.getRestaurantId());
        restaurantTable.setRestaurant(restaurant);
        restaurantTable.setCapacityOfTable(request.getCapacityPerTable());
        restaurantTable.setReservationCheck(request.getReservationCheck());
        Integer maxTableNumber = restaurantTableRepository.findMaxTableNumberByRestaurantId(request.getRestaurantId());
        if (maxTableNumber == null) {
            maxTableNumber = 1;
        }
        restaurantTable.setTableNumber(maxTableNumber + 1);

        return restaurantTable;
    }

    public RestaurantTable findTableByRestaurantIdAndTableNumber(Long restaurantId, Integer tableNumber) {
        return restaurantTableRepository.findByRestaurantIdAndTableNumber(restaurantId, tableNumber);
    }
}