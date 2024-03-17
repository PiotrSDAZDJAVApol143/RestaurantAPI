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

    public Restaurant updateRestaurant(Long id, RestaurantReqDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restauration not found"));
        if(requestDto.getRestaurantName() !=null){
            restaurant.setRestaurantName(requestDto.getRestaurantName());
        }
        if(requestDto.getImagesFromRestaurant() !=null) {
            restaurant.setImagesFromRestaurant(requestDto.getImagesFromRestaurant());
        }
        if(requestDto.getAddressDto() !=null){
            restaurant.setAddress(requestDto.getAddressDto());
        }
        if(requestDto.getAddressDto() !=null){
            restaurant.setAddress(requestDto.getAddressDto());
        }
        if(requestDto.getTables() !=null){
            restaurant.setTables(requestDto.getTables());
        }
        if(requestDto.getOpeningHours() !=null){
            restaurant.setOpeningHours(requestDto.getOpeningHours());
        }
        if(requestDto.getClosingHours() !=null){
            restaurant.setClosingHours(requestDto.getClosingHours());
        }
        if(requestDto.getFoodTypes() !=null){
            restaurant.setFoodTypes(requestDto.getFoodTypes());
        }
        return restaurantRepository.save(restaurant);
    }
    public void deleteRestaurant(Long id) {
        if(!restaurantRepository.existsById(id)){
            throw  new EntityNotFoundException("Restaurant not found");
        }
        restaurantRepository.deleteById(id);
    }
}
