package com.nikolenko.movieland.controller;

import com.nikolenko.movieland.dao.entity.SortOrderParameter;
import com.nikolenko.movieland.dao.entity.SortOrderType;
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
        public List<Movie> getAll(@RequestParam(name = "price", required = false) String orderByPrice, @RequestParam(name = "rating", required = false) String orederByRating ) {
            if (orderByPrice==null && orederByRating==null ){
                return movieService.getAll();
            }

            SortOrderParameter sortOrderParameter = new SortOrderParameter();
            if (orderByPrice != null) { sortOrderParameter.add("price", SortOrderType.getSortOrderTypeByName(orderByPrice));}
            if (orederByRating != null) { sortOrderParameter.add("movie_rate", SortOrderType.getSortOrderTypeByName(orederByRating));}
            return movieService.getAll(sortOrderParameter);
        }

        @RequestMapping(method = RequestMethod.GET, path = "/random", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public List<Movie> getRandom() {
            return movieService.getRandom();
        }

        @RequestMapping(method = RequestMethod.GET, path = "/genre/{genreId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public List<Movie> getMoviesByGenre(@PathVariable("genreId") int genreId) {
            return movieService.getMoviesByGenre((int)genreId);
        }
    }

