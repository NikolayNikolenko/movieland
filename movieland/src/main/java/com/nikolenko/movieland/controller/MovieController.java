package com.nikolenko.movieland.controller;

import com.nikolenko.movieland.entity.Movie;
import com.nikolenko.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(path = "/v1/movie")
    public class MovieController {
        private MovieService movieService;

        @Autowired
        public MovieController(MovieService movieService) {
            this.movieService = movieService;
        }

        @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public List<Movie> getAll() {
            return movieService.getAll();
        }

        @RequestMapping(method = RequestMethod.GET, path = "/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public List<Movie> getRandom() {
            return movieService.getRandom();
        }

        @RequestMapping(method = RequestMethod.GET, path = "/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public List<Movie> getMoviesByGenre(@PathVariable("genreId") long genreId) {
            return movieService.getMoviesByGenre((int)genreId);
        }
    }

