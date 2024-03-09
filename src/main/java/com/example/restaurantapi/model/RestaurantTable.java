package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "RESTAURANT_TABLE")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;
    @Column(name = "NUMBER_OF_TABLES",nullable = false)
    private Integer numberOfTables;

}
