package com.example.spring_cinema.controllers;

import com.example.spring_cinema.movies.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import com.example.spring_cinema.services.MovieService;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    MovieService movieService;      //removed private at start; not required.

    @PostMapping                             //route added to POST movies (/movies in postman).
    public ResponseEntity<Movie> addMovies(@RequestBody Movie movie) {      //Movie was an imported class, initially showing up red. the data is stored in the @request body, in the movie object's shape e.g. with such properties.
        //Movie savedMovie =    this has been commented out from the next line's code (which it formed the initial part of) bc it is not needed here, due to movie having an id already (?)
        movieService.addMovie(movie);                //instructs the body to save/add new movie.
        return new ResponseEntity<>(movie, HttpStatus.CREATED);     //attaches id to the movie
    }

//google RESTful routes

    @GetMapping                              //route added to GET a list of movies. See RESTful routes, which asserts GET is what is needed here.
    public List<Movie> getAllMovies() {
        return movieService.getMovieList();
    }
    //should have also added a line between 33 & 34 - see recording for rationale.


    @GetMapping(value = "/{id}")             //route added to GET movies by id (/movies/id in postman).
    public ResponseEntity<Movie> getMovieId(@PathVariable long id) {
        Optional<Movie> movie = movieService.getMovieId(id);
        return new ResponseEntity<>(movie.get(), HttpStatus.CREATED);
    }

    //could also add the following to the above get mapping:
//    Optional<Movie> getMovieById(@PathVariable long id);
//    if(optionalMovie.isEmpty()){
//        return new ResponseEntity<>(optionalMovie.get()HttpEntity.)
//    }



}
