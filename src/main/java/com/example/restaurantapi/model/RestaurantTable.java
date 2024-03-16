package com.example.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Table(name = "RESTAURANT_TABLE")

public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)  //powiązanie usuwania tabeli
    @JsonBackReference
    private Restaurant restaurant;
    @Column(name = "TABLE_NUMBER",nullable = false)
    private Integer tableNumber;
    @Column(name = "CAPACITY_OF_TABLE",nullable = false)
    private Integer capacityOfTable;
    @Column(name = "RESERVATION")
    private Boolean reservation;

}
