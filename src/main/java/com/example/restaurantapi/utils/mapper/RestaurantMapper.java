package com.example.restaurantapi.utils.mapper;


import com.example.restaurantapi.dto.RestaurantTableDTO;
import com.example.restaurantapi.dto.RestaurantWriteDto;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.RestaurantTable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {

//

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
            List<RestaurantTable> tableDTOs = tables.stream()
                    .map(this::mapTableToDTO)
                    .collect(Collectors.toList());
            dto.setTables(tableDTOs);
        }

        return dto;
    }

    private RestaurantTable mapTableToDTO(RestaurantTable table) {
        RestaurantTable tableDTO = new RestaurantTable();
        tableDTO.setTableNumber(table.getTableNumber());
        tableDTO.setCapacityOfTable(table.getCapacityOfTable());
        return tableDTO;
    }
}
