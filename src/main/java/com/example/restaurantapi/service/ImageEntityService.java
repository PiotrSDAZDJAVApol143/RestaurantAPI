package com.example.restaurantapi.service;

import com.example.restaurantapi.model.ImageEntity;
import com.example.restaurantapi.repository.ImageEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class ImageEntityService {

    private final ImageEntityRepository imageRepository;

    public ImageEntity getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public void saveImage(byte[] image) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(image);
        imageRepository.save(imageEntity);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }


}
