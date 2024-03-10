package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "RESTAURANT_TABLE")
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)  //powiązanie usuwania tabeli
    private Restaurant restaurant;
    @Column(name = "TABLE_NUMBER",nullable = false)
    private Integer tableNumber;
    @Column(name = "CAPACITY_OF_TABLE",nullable = false)
    private Integer capacityOfTable;

}
