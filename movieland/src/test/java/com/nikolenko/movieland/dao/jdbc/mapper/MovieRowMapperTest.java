package com.nikolenko.movieland.dao.jdbc.mapper;

import com.nikolenko.movieland.entity.Movie;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {
    @Test
    public void testMapRow() throws SQLException {

        MovieRowMapper movieRowMapper = new MovieRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("movie_id")).thenReturn(1);
        when(resultSet.getString("movie_name_russian")).thenReturn("Список Шиндлера");
        when(resultSet.getString("movie_name_native")).thenReturn("Schindler's List");
        when(resultSet.getInt("year_of_release")).thenReturn(1993);
        when(resultSet.getDouble("movie_rate")).thenReturn(8.7);
        when(resultSet.getDouble("price")).thenReturn(150.5);
        when(resultSet.getString("poster_url")).thenReturn("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");

        Movie actualMovie = movieRowMapper.mapRow(resultSet, 0);

        assertEquals(1, actualMovie.getId());
        assertEquals("Список Шиндлера", actualMovie.getNameRussian());
        assertEquals("Schindler's List", actualMovie.getNameNative());
        assertEquals(1993, actualMovie.getYearOfRelease());
        assertEquals(8.7, actualMovie.getRating(), 0.1);
        assertEquals(150.5, actualMovie.getPrice(), 0.1);
        assertEquals("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg", actualMovie.getPicturePath());
    }
}
