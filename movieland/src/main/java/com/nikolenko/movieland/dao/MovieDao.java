package com.nikolenko.movieland.dao;

import com.nikolenko.movieland.entity.Movie;

import java.util.List;

public interface MovieDao{

    public List<Movie> getAllMovies();
    public List<Movie> getRandomMovies();
}
