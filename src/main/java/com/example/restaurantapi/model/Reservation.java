package com.example.restaurantapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RESERVATION_DATE")
    @FutureOrPresent(message = "The reservation date must be current or future")
    private LocalDateTime reservationDate;

    @Column(name = "NUMBER_OF_PEOPLE")
    @Min(value = 1, message = "Number of people for which a reservation can be made must be greater than 0")
    private Integer numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private RestaurantTable table;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

