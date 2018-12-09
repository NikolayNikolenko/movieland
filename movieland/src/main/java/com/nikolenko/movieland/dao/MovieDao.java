package com.nikolenko.movieland.dao;

import com.nikolenko.movieland.dao.entity.SortOrderParameter;
import com.nikolenko.movieland.entity.Movie;

import java.util.List;

public interface MovieDao{

    public List<Movie> getAllMovies();
    public List<Movie> getAllMovies(SortOrderParameter sortOrderParameter);
    public List<Movie> getRandomMovies();
    public List<Movie> getMoviesByGenre(int genreId);
    public List<Movie> getMoviesByGenre(int genreId, SortOrderParameter sortOrderParameter);
}
