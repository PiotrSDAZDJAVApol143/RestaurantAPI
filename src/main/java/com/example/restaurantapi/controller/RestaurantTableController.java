package com.example.restaurantapi.controller;

import com.example.restaurantapi.dto.RestaurantTableDTO;
import com.example.restaurantapi.dto.RestaurantWriteDto;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.RestaurantTable;
import com.example.restaurantapi.service.RestaurantService;
import com.example.restaurantapi.service.RestaurantTableService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurant/{id}/table")
@Validated
@RequiredArgsConstructor
public class RestaurantTableController {
    private final RestaurantService restaurantService;
    private final RestaurantTableService restaurantTableService;

    @PatchMapping("/updateAllTables")
    public ResponseEntity<List<RestaurantTable>> updateAllTables(@PathVariable("id") Long restaurantId,
                                                                 @Valid @RequestBody List<RestaurantTableDTO> tables) {
        List<RestaurantTable> updateListOfTablesInRestaurant = restaurantTableService.updateTablesInRestaurant(restaurantId, tables);
        return ResponseEntity.ok(updateListOfTablesInRestaurant);
    }
    @PutMapping("/addTable")
    public ResponseEntity<RestaurantTable> createTable(@PathVariable("id") Long restaurantId,
                                                       @Valid @RequestBody RestaurantTableDTO request) {
        RestaurantTable restaurantTable = restaurantTableService.buildTable(request);
        restaurantTable = restaurantTableService.saveRestaurantTable(restaurantId, restaurantTable);
        return new ResponseEntity<>(restaurantTable, HttpStatus.CREATED);
    }
    @DeleteMapping("/{tableId}")
    public ResponseEntity<Void> deleteTableFromRestaurant(@PathVariable("id") Long restaurantId, @Valid @PathVariable Long tableId) {
        restaurantTableService.deleteRestaurantTable(restaurantId, tableId);
        return ResponseEntity.noContent().build();
    }


}