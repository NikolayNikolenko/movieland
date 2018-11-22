package com.nikolenko.movieland.dao.jdbc.mapper;

import com.nikolenko.movieland.entity.Movie;

import java.util.List;

public interface MovieDao{

    public List<Movie> getAllMovies();
}
