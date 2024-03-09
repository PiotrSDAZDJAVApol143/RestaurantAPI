package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.HashSet;
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

    @ElementCollection
    @CollectionTable(name = "RESTAURANT_FOOD_TYPE", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "FOOD_TYPE")
    private Set<String> foodTypes = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "RESTAURANT_TABLES", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "TABLES_NUMBERS")
    private Set<Integer> tablesNumbers = new HashSet<>();


}
