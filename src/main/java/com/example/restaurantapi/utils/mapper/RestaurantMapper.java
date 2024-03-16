package com.example.restaurantapi.utils.mapper;


import com.example.restaurantapi.dto.RestaurantTableDTO;
import com.example.restaurantapi.dto.RestaurantWriteDto;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.RestaurantTable;
import com.example.restaurantapi.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RestaurantMapper {
    private final RestaurantRepository restaurantRepository;

    public RestaurantWriteDto toDto(Restaurant restaurant){
        RestaurantWriteDto dto = RestaurantWriteDto.builder()
                .id(restaurant.getId())
                .restaurantName(restaurant.getRestaurantName())
                .addressDto(restaurant.getAddress())
                .openingHours(restaurant.getOpeningHours())
                .closingHours(restaurant.getClosingHours())
                .imagesFromRestaurant(restaurant.getImagesFromRestaurant())
                .foodTypes(restaurant.getFoodTypes())
                .build();

        List<RestaurantTable> tables = restaurant.getTables();
        if (tables != null) {
            List<RestaurantTableDTO> tableDTOs = tables.stream()
                    .map(this::mapTableToDTO)
                    .collect(Collectors.toList());
            dto.setTables(tableDTOs);
        }

        return dto;
    }

    private RestaurantTableDTO mapTableToDTO(RestaurantTable table) {
        RestaurantTableDTO tableDTO = new RestaurantTableDTO();
        tableDTO.setId(table.getId());
        tableDTO.setRestaurantId(table.getRestaurant().getId()); // Pobierz id z obiektu Restaurant
        tableDTO.setTableNumber(table.getTableNumber());
        tableDTO.setCapacityPerTable(table.getCapacityOfTable());
        return tableDTO;
    }
}
