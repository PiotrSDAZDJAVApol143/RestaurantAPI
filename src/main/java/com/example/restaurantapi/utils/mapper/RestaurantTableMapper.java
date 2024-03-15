package com.example.restaurantapi.utils.mapper;

import com.example.restaurantapi.dto.RestaurantTableDTO;
import com.example.restaurantapi.model.RestaurantTable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component

public class RestaurantTableMapper {
    public RestaurantTableDTO mapTableToDTO(RestaurantTable table) {
        return RestaurantTableDTO.builder()
                .tableNumber(table.getTableNumber())
                .capacityPerTable(table.getCapacityOfTable())
                .build();
    }

}
