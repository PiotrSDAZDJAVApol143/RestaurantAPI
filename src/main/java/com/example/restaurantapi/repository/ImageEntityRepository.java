package com.example.restaurantapi.repository;
import com.example.restaurantapi.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageEntityRepository extends JpaRepository<ImageEntity, Long> {

}
