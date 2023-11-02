package com.example.spring_cinema.services;

import com.example.spring_cinema.controllers.MovieController;
import com.example.spring_cinema.movies.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;        //to connect this class to the controller.

    public MovieService(){
    }



    // methods to view, find (by ID) and add new movies to the repository:
    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }



    // to add a new movie:
    public Movie addMovie(Movie movie) {
        assert movieRepository != null;
        return movieRepository.save(movie);
    }

    //to find a movie in table's id field:
    public Optional<Movie> getMovieId(long id) {
        assert movieRepository != null;             //assert that movie is empty/not 'null'
        return movieRepository.findById(id);        //return all the contents of movie repo interface.
    }
}
