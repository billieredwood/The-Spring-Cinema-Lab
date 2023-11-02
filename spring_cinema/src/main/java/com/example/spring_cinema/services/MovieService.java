package com.example.spring_cinema.services;

import com.example.spring_cinema.controllers.MovieController;
import com.example.spring_cinema.movies.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;        //to connect this class to the repository.

    @Autowired
    MovieController movieController;        //to connect this class to the controller.

    private List<Movie> movieList;

    public MovieService(){
    }


    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }


    // methods to view, find (by ID) and add new movies to the repository:
    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    //to find a movie in table's id field:
    public Movie getMovieId(Long id) {
        return movieRepository.getReferenceById(id);
    }

    // to add a new movie:
    public Movie addMovie(Movie movie) {
        assert movieRepository != null;
        return movieRepository.save(movie);
    }
}
