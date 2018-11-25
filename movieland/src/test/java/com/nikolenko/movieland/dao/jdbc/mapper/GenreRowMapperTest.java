package com.nikolenko.movieland.dao.jdbc.mapper;

import com.nikolenko.movieland.entity.Genre;
import org.junit.Test;
import org.mockito.Mock;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenreRowMapperTest {
    @Test
    public void rowMapperTest() throws SQLException {
        GenreRowMapper genreRowMapper = new GenreRowMapper();
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("genre_id")).thenReturn(1);
        when(resultSet.getString("genre_name")).thenReturn("драма");

        Genre actualGenre = genreRowMapper.mapRow(resultSet, 0);

        assertEquals(1, actualGenre.getId());
        assertEquals("драма", actualGenre.getName());
    }
}
