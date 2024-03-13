package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"imagesFromRestaurant", "tables"})

@Table(name = "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RESTAURANT_NAME", length = 128, nullable = false)
    private String restaurantName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "OPENING_HOURS", nullable = false)
    private LocalTime openingHours;

    @Column(name = "CLOSING_HOURS", nullable = false)
    private LocalTime closingHours;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ImageEntity> imagesFromRestaurant;


    @ElementCollection(targetClass = FoodType.class)
    @CollectionTable(name = "RESTAURANT_FOOD_TYPE", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "FOOD_TYPE")
    @Enumerated(EnumType.STRING)
    private Set<FoodType> foodTypes = new HashSet<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantTable> tables = new ArrayList<>();

}