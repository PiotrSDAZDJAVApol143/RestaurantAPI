package com.example.restaurantapi.controller;

import com.example.restaurantapi.service.ImageEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
