package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.ImageEntity;
import com.example.restaurantapi.service.ImageEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("/restaurant/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageEntityService imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            byte[] imageBytes = file.getBytes();
            imageService.saveImage(imageBytes);
            return "Plik został pomyślnie przesłany";
        } catch (Exception e) {
            return "Przesyłanie nie powiodło się: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteImage(@PathVariable Long id) {
        try {
            imageService.deleteImage(id);
            return "Obraz został pomyślnie usunięty";
        } catch (Exception e) {
            return "Usunięcie nie powiodło się: " + e.getMessage();
        }
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<byte[]> showImageByID(@PathVariable Long id){
        ImageEntity imageEntity = imageService.getImageById(id);
        if (imageEntity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageEntity.getImage());
    }


}
