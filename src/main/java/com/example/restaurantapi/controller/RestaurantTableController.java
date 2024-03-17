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
        List<RestaurantTable> updateListOfTablesInRestaurant = restaurantTableService.updateTablesInRestaurant(restaurantId,tables);
        return ResponseEntity.ok(updateListOfTablesInRestaurant);
     //   try {
     //       for (RestaurantTableDTO table : tables) {
     //           restaurantTableService.updateCapacityOfTableById(restaurantId, table.getId(), table.getCapacityPerTable());
     //       }
     //       return ResponseEntity.ok().build();
     //   } catch (EntityNotFoundException e) {
     //       return ResponseEntity.notFound().build();
     //   } catch (IllegalArgumentException e) {
     //       return ResponseEntity.badRequest().build();
     //   }
    }

  //  @PatchMapping("/updateCapacity/{id}")
  //  public ResponseEntity<RestaurantTable> updateCapacityOfTableById(@PathVariable(value = "id") Long tableId,
  //                                                                   @RequestParam Integer capacityOfTable,
  //                                                                   @RequestParam Long restaurantId) {
  //      try {
  //          RestaurantTable updatedRestaurantTable = restaurantTableService.updateCapacityOfTableById(restaurantId, tableId, capacityOfTable);
  //          return ResponseEntity.ok(updatedRestaurantTable);
  //      } catch (EntityNotFoundException e) {
  //          return ResponseEntity.notFound().build();
  //      } catch (IllegalArgumentException e) {
  //          return ResponseEntity.badRequest().build();
  //      }
  //  }

 //   @DeleteMapping("/delete/{id}")
 //   public ResponseEntity<Void> deleteTable(@PathVariable("id") Long tableId,
 //                                           @RequestParam Long restaurantId) {
 //       try {
 //           restaurantTableService.deleteRestaurantTable(restaurantId, tableId);
 //           return ResponseEntity.noContent().build();
 //       } catch (EntityNotFoundException e) {
 //           return ResponseEntity.notFound().build();
 //       } catch (IllegalArgumentException e) {
 //           return ResponseEntity.badRequest().build();
 //       }
 //   }
//
 //   @PutMapping("/createTable/{restaurantId}")
 //   public ResponseEntity<RestaurantTable> createTable(@PathVariable("restaurantId") Long restaurantId,
 //                                                      @RequestBody RestaurantTable restaurantTable) {
 //       try {
 //           Restaurant restaurant = restaurantService.findRestaurantTableById(restaurantId);
 //           if (restaurant != null) {
 //               restaurantTable.setRestaurant(restaurant);
 //               RestaurantTable newTable = restaurantTableService.saveRestaurantTable(restaurantId, restaurantTable);
 //               return ResponseEntity.ok(newTable);
 //           } else {
 //               return ResponseEntity.notFound().build();
 //           }
 //       } catch (EntityNotFoundException e) {
 //           return ResponseEntity.notFound().build();
 //       }
 //   }
}

//  @PatchMapping("/updateCapacity/{id}")
//  public ResponseEntity<RestaurantTable> updateCapacityOfTableById(@PathVariable(value = "id") Long tableId,
//                                                                   @RequestParam Integer capacityOfTable) {
//      RestaurantTable updatedRestaurantTable = restaurantTableService.updateCapacityOfTableById(tableId, capacityOfTable);
//      if (updatedRestaurantTable == null) {
//          return ResponseEntity.notFound().build();
//      }
//      return ResponseEntity.ok(updatedRestaurantTable);
//  }

//  @DeleteMapping("/delete/{id}")
//  public ResponseEntity<Void> deleteTable(@PathVariable("id") Long id) {
//      try {
//          restaurantTableService.deleteRestaurantTable(id);
//          return ResponseEntity.noContent().build();
//      } catch (EntityNotFoundException e) {
//          return ResponseEntity.notFound().build();
//      }
//  }

//  @PutMapping("/createTable/{restaurantId}")
//  public ResponseEntity<RestaurantTable> createTable(@PathVariable("restaurantId") Long restaurantId, @RequestBody RestaurantTable restaurantTable) {
//      Restaurant restaurant = restaurantService.findRestaurantTableById(restaurantId);
//      if (restaurant != null) {
//          restaurantTable.setRestaurant(restaurant);
//          RestaurantTable newTable = restaurantTableService.saveRestaurantTable(restaurantTable);
//          return ResponseEntity.ok(newTable);
//      } else {
//          return ResponseEntity.notFound().build();
//      }
//  }