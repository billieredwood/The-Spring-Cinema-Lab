package com.example.spring_cinema.repositories;

import com.example.spring_cinema.movies.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {       //movie and long won't get combined until you run the programme.
}

//this is a spring repo that stores movies.
