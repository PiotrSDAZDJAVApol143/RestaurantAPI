package com.example.restaurantapi.service;

import com.example.restaurantapi.dto.AddressDto;
import com.example.restaurantapi.dto.RestaurantReqDto;
import com.example.restaurantapi.dto.RestaurantWriteDto;
import com.example.restaurantapi.model.Address;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.RestaurantTable;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.RestaurantTableRepository;
import com.example.restaurantapi.utils.mapper.RestaurantMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantMapper restaurantMapper;


    public Restaurant createRestaurant(String restaurantName) {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setRestaurantName(restaurantName);
        return restaurantRepository.save(newRestaurant);
    }

    public Restaurant buildRestaurant(RestaurantReqDto requestDto) {
        Address address = buildAddress(requestDto.getAddressDto());

        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(requestDto.getRestaurantName());
        restaurant.setAddress(address);
        restaurant.setOpeningHours(requestDto.getOpeningHours());
        restaurant.setClosingHours(requestDto.getClosingHours());
        restaurant.setImagesFromRestaurant(requestDto.getImagesFromRestaurant());
        restaurant.setFoodTypes(requestDto.getFoodTypes());
        restaurantRepository.save(restaurant);
        List<RestaurantTable> tables = requestDto.getTables();
        if (tables != null && !tables.isEmpty()) {
            for (RestaurantTable table : tables) {
                table.setRestaurant(restaurant);
            }
            restaurantTableRepository.saveAll(tables);
        }
        return restaurant;
    }

    private Address buildAddress(Address address){
        Address addressBuild = new Address();
        addressBuild.setName(address.getName());
        addressBuild.setStreet(address.getStreet());
        addressBuild.setBuildingNumber(address.getBuildingNumber());
        addressBuild.setLocalNumber(address.getLocalNumber());
        addressBuild.setCity(address.getCity());
        addressBuild.setZipCode(address.getZipCode());
        addressBuild.setCountry(address.getCountry());
        return addressBuild;

    }



    public Restaurant findOrCreateRestaurant(Restaurant restaurant) {
        // Sprawdzenie, czy restauracja już istnieje w bazie danych
        Restaurant existingRestaurant = restaurantRepository.findByRestaurantName(restaurant.getRestaurantName());

        if (existingRestaurant != null) {
            // Jeśli restauracja istnieje, zwróć ją
            return existingRestaurant;
        } else {
            // Jeśli restauracja nie istnieje, zapisz nową restaurację w bazie danych
            return restaurantRepository.save(restaurant);
        }
    }



    public RestaurantWriteDto findById(Long id) {
        return restaurantRepository.findById(id)
                .map(restaurantMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + id));
    }
    public Restaurant findRestaurantTableById(Long id){
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + id));
    }

    public Restaurant updateRestaurant(Long id, Restaurant request) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restauration not found"));

        restaurant.setRestaurantName(request.getRestaurantName());
        restaurant.setImagesFromRestaurant(request.getImagesFromRestaurant());
        restaurant.setAddress(request.getAddress());
        restaurant.setTables(request.getTables());
        restaurant.setOpeningHours(request.getOpeningHours());
        restaurant.setClosingHours(request.getClosingHours());
        restaurant.setFoodTypes(request.getFoodTypes());
        return restaurantRepository.save(restaurant);
    }
    public void deleteRestaurant(Long id) {
        if(!restaurantRepository.existsById(id)){
            throw  new EntityNotFoundException("Restaurant not found");
        }
        restaurantRepository.deleteById(id);
    }
}
/* List<RestaurantTable> tables = requestDto.getTables();
        if (tables != null && !tables.isEmpty()) {
            for (int i = 0; i < tables.size(); i++) {
                RestaurantTable table = tables.get(i);
                table.setTableNumber(i + 1);
                table.setRestaurant(restaurant);
            }
            restaurant.setTables(tables);
        }

 */