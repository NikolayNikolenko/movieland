package com.nikolenko.movieland.service.impl;

import com.nikolenko.movieland.dao.MovieDao;
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
    public List<Movie> getRandom() {
        return movieDao.getRandomMovies();
    }
}
