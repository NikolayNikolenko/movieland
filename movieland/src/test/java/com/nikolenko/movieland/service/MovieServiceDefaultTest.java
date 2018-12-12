package com.nikolenko.movieland.service;

import com.nikolenko.movieland.dao.MovieDao;
import com.nikolenko.movieland.entity.Movie;
import com.nikolenko.movieland.service.impl.MovieServiceDefault;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieServiceDefaultTest {
    @Test
    public void getAllMovies() {
        MovieDao movieDao = mock(MovieDao.class);

        List<Movie> expectedMovieList = new ArrayList<Movie>();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setNameRussian("Список Шиндлера");
        movie1.setNameNative("Schindler's List");
        movie1.setYearOfRelease(1993);
        movie1.setRating(8.7);
        movie1.setPrice(150.5);
        movie1.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setNameRussian("Пролетая над гнездом кукушки");
        movie2.setNameNative("One Flew Over the Cuckoo''s Nest");
        movie2.setYearOfRelease(1975);
        movie2.setRating(8.7);
        movie2.setPrice(180);
        movie2.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg");
        expectedMovieList.add(movie2);

        MovieServiceDefault movieService = new MovieServiceDefault(movieDao);

        when(movieDao.getAllMovies()).thenReturn(expectedMovieList);

        List<Movie> actualMovieList = movieService.getAll();

        assertEquals(2, actualMovieList.size());

        for (Movie actualMovie : actualMovieList) {
            assertTrue(expectedMovieList.contains(actualMovie));
        }

    }

}
