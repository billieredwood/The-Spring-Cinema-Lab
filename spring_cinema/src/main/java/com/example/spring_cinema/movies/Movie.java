package com.example.spring_cinema.movies;

import jakarta.persistence.*;

// to create database:
@Entity
@Table(name = "movies")     //creating database table:
public class Movie {
    @Id // can't be changed/edited in database
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to create SQL tables from properties as follows:
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private int rating;
    @Column (name = "duration")
    private int duration;

    //constructing movie object from above-named properties.
    public Movie(String title, int rating, int duration){
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    //default constructor:
    public Movie(){
    }

    // getters and setters for other classes to access movie properties:
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
