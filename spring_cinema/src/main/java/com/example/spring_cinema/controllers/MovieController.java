package com.example.spring_cinema.controllers;

import com.example.spring_cinema.movies.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")      //to send anything coded below to localhost:8080/movies
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping                             //route added to POST movies (/movies in postman).
    public ResponseEntity<Movie> addMovies(@RequestBody Movie movie) {
        Movie savedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }



    @GetMapping                               //route added to GET a list of movies.
    public List<Movie> getAllMovies() {
        return movieService.getMovieList();
    }

    @GetMapping(value = "/{id}")             //route added to GET movies by id (/movies/id in postman).
    public ResponseEntity<Movie> getMovieId(@PathVariable long id) {
        Optional<Movie> movie = movieService.getMovieId(id);
        return new ResponseEntity<>(movie.get(), HttpStatus.CREATED);
    }


}
