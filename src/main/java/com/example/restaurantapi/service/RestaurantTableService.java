package com.example.restaurantapi.service;

import com.example.restaurantapi.dto.RestaurantTableConfigurationDTO;
import com.example.restaurantapi.model.Restaurant;
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
        if (!optionalRestaurantTable.isPresent()) {
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


 //  public Restaurant createRestaurantTableConfiguration(RestaurantTableConfigurationDTO configurationDTO) {
 //      String restaurantName = configurationDTO.getRestaurantName();
 //      int numberOfTables = configurationDTO.getNumberOfTables();
 //      Restaurant restaurant = restaurantRepository.findByRestaurantName(restaurantName)
 //              .orElseGet(() -> createRestaurant(restaurantName));


 //      private RestaurantTable buildRestaurantTableConfiguration (Restaurant restaurant, Integer numberOfTables){
 //          RestaurantTable restaurantTable = new RestaurantTable();
 //          restaurantTable.setRestaurant(restaurant);
 //          restaurantTable.setNumberOfTables(numberOfTables);
 //          return restaurantTable;
 //      }
 //      private Restaurant createRestaurant (String restaurantName){
 //          Restaurant newRestaurant = new Restaurant();
 //          newRestaurant.setRestaurantName(restaurantName);
 //          return restaurantRepository.save(newRestaurant);
 //      }


 //  }
//   public RestaurantTable createRestaurantTableConfiguration(String restaurantName, Integer numberOfTables){
//       Restaurant restaurant = restaurantService.findOrCreateRestaurant(restaurantName);
//       RestaurantTable restaurantTableConfig = buildRestaurantTableConfiguration(restaurant,numberOfTables);
//       return restaurantTableRepository.save(restaurantTableConfig);
//   }

//   private RestaurantTable buildRestaurantTableConfiguration(Restaurant restaurant, Integer numberOfTables) {
//       RestaurantTable restaurantTable = new RestaurantTable();
//       restaurantTable.setRestaurant(restaurant);
//       restaurantTable.setNumberOfTables(numberOfTables);
//       return restaurantTable;
//   }