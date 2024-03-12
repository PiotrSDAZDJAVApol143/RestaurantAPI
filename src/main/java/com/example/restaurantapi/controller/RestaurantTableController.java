package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.RestaurantTable;
import com.example.restaurantapi.service.RestaurantService;
import com.example.restaurantapi.service.RestaurantTableService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/table")
@Validated
@RequiredArgsConstructor
public class RestaurantTableController {
    private final RestaurantService restaurantService;
    private final RestaurantTableService restaurantTableService;


    @PatchMapping("/updateCapacity/{id}")
    public ResponseEntity<RestaurantTable> updateCapacityOfTableById(@PathVariable(value = "id") Long tableId,
                                                                     @RequestParam Integer capacityOfTable) {
        RestaurantTable updatedRestaurantTable = restaurantTableService.updateCapacityOfTableById(tableId, capacityOfTable);
        if (updatedRestaurantTable == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRestaurantTable);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable("id") Long id) {
        try {
            restaurantTableService.deleteRestaurantTable(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/createTable/{restaurantId}")
    public ResponseEntity<RestaurantTable> createTable(@PathVariable("restaurantId") Long restaurantId, @RequestBody RestaurantTable restaurantTable) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        if (restaurant != null) {
            restaurantTable.setRestaurant(restaurant);
            RestaurantTable newTable = restaurantTableService.saveRestaurantTable(restaurantTable);
            return ResponseEntity.ok(newTable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

//  @PostMapping("/add")
//  public ResponseEntity<RestaurantTable> addRestaurantConfiguration(@Valid @RequestBody RestaurantReqDto request) {
//      RestaurantTable restaurantTable = restaurantTableService.createRestaurantTableConfiguration(request.getRestaurantName(), request.getNumberOfTablesInRestaurant());
//      return new ResponseEntity<>(restaurantTable, HttpStatus.CREATED);
//  }
// @PostMapping("/add")
// public ResponseEntity<String> addRestaurantConfiguration(@RequestBody RestaurantTableConfigurationDTO configurationDTO) {
//     try {
//         restaurantTableService.createRestaurantTableConfiguration(configurationDTO);
//         return ResponseEntity.ok("Restaurant table configuration added successfully.");
//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add restaurant table configuration.");
//     }
// }
