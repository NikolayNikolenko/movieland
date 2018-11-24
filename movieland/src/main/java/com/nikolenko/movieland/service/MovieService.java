package com.nikolenko.movieland.service;

import com.nikolenko.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    List<Movie> getRandom();
}
