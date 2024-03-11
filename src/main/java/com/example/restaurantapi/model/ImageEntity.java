package com.example.restaurantapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

   // @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image;
}
