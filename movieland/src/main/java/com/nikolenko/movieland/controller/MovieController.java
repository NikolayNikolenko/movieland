package com.nikolenko.movieland.controller;

import com.nikolenko.movieland.entity.Movie;
import com.nikolenko.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

    @Controller
    @RequestMapping("/v1")
    public class MovieController {
        @Autowired
        private MovieService movieService;
        @RequestMapping(method = RequestMethod.GET, path = "/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        @ResponseBody
        public List<Movie> getAllMovies() {
            return movieService.getAll();
        }

        public MovieService getMovieService() {
            return movieService;
        }

        public void setMovieService(MovieService movieService) {
            this.movieService = movieService;
        }
    }

