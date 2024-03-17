package com.example.restaurantapi.repository;

import com.example.restaurantapi.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    @Query("SELECT MAX(rt.tableNumber) FROM RestaurantTable rt WHERE rt.restaurant.id = :restaurantId")
    Integer findMaxTableNumberByRestaurantId(@Param("restaurantId") Long restaurantId);
}
