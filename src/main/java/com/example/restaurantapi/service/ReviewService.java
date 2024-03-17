package com.example.restaurantapi.service;

import com.example.restaurantapi.dto.ReviewDto;
import com.example.restaurantapi.model.Restaurant;
import com.example.restaurantapi.model.Review;
import com.example.restaurantapi.model.User;
import com.example.restaurantapi.repository.RestaurantRepository;
import com.example.restaurantapi.repository.ReviewRepository;
import com.example.restaurantapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    public Review createReview(Long id, ReviewDto reviewDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + id));
        User user = userRepository.findById(reviewDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + reviewDto.getUserId()));
        Review review = new Review();
        review.setUser(user);
        review.setRestaurant(restaurant);
        review.setRating(reviewDto.getRating());
        review.setReviewText(reviewDto.getReviewText());
        return reviewRepository.save(review);
    }
}
