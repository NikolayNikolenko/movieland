package com.nikolenko.movieland.service;

import com.nikolenko.movieland.dao.entity.SortOrderParameter;
import com.nikolenko.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getAll(SortOrderParameter sortOrderParameter);

    List<Movie> getRandom();

    List<Movie> getMoviesByGenre(int genreId);

    List<Movie> getMoviesByGenre(int genreId, SortOrderParameter sortOrderParameter);
}
