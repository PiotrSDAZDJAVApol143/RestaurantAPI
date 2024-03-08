package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",length = 128)
    private String name;

    @Column(name = "STREET",length = 128, nullable = false)
    private String street;

    @Column(name = "BUILDING_NUMBER",length = 128, nullable = false)
    private String buildingNumber;
    @Column(name = "LOCAL_NUMBER",length = 128)
    private String localNumber;

    @Column(name = "CITY",length = 128, nullable = false)
    private String city;

    @Column(name = "ZIP_CODE",length = 128, nullable = false)
    private String zipCode;

    @Column(name = "COUNTRY",length = 128, nullable = false)
    private String country;


}
