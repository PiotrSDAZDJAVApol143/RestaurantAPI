package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
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

    @ElementCollection(targetClass = FoodType.class)
    @CollectionTable(name = "RESTAURANT_FOOD_TYPE", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "FOOD_TYPE")
    @Enumerated(EnumType.STRING)
    private Set<FoodType> foodTypes = new HashSet<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RestaurantTable> tables;

}
// @ElementCollection
// @CollectionTable(name = "RESTAURANT_FOOD_TYPE", joinColumns = @JoinColumn(name = "restaurant_id"))
// @Column(name = "FOOD_TYPE")
// private Set<String> foodTypes = new HashSet<>();

//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//@JoinTable(name = "RESTAURANT_TABLES",
//        joinColumns = @JoinColumn(name = "restaurant_id"),
//        inverseJoinColumns = @JoinColumn(name = "table_id"))
//private Set<RestaurantTable> tablesNumbers = new HashSet<>();