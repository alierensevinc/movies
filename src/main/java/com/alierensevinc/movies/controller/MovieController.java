package com.alierensevinc.movies.controller;

import com.alierensevinc.movies.model.Movie;
import com.alierensevinc.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
