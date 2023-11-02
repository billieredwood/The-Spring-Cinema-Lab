package com.example.spring_cinema.movies;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to create SQL tables as follows:
    private Long id;
    @Column
    private String title;
    @Column
    private int rating;
    @Column
    private int duration;

    public Movie(String title, int rating, int duration){
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public Movie(){
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
