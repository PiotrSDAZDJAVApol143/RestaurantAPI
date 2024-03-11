package com.example.restaurantapi.service;

import com.example.restaurantapi.model.ImageEntity;
import com.example.restaurantapi.repository.ImageEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageEntityService {

    private final ImageEntityRepository imageRepository;
    public void saveImage(byte[] image) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(image);
        imageRepository.save(imageEntity);
    }
}
