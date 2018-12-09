package com.nikolenko.movieland.service.impl;

import com.nikolenko.movieland.dao.MovieDao;
import com.nikolenko.movieland.dao.entity.SortOrderParameter;
import com.nikolenko.movieland.entity.Movie;
import com.nikolenko.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceDefault implements MovieService {
    private MovieDao movieDao;

    @Autowired
    public MovieServiceDefault(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getAll() {
        return movieDao.getAllMovies();
    }

    @Override
    public List<Movie> getAll(SortOrderParameter sortOrderParameter) {
        return movieDao.getAllMovies(sortOrderParameter);
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getRandomMovies();
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId) {
        return movieDao.getMoviesByGenre(genreId);
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId, SortOrderParameter sortOrderParameter) {
        return movieDao.getMoviesByGenre(genreId, sortOrderParameter);
    }

}
