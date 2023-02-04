package com.alierensevinc.movies.controller;

import com.alierensevinc.movies.model.Review;
import com.alierensevinc.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/movies")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(reviewService.saveReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

}
