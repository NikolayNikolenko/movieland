package com.nikolenko.movieland.dao.impl.jdbc.mapper;

import com.nikolenko.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("movie_id"));
        movie.setNameRussian(resultSet.getString("movie_name_russian"));
        movie.setNameNative(resultSet.getString("movie_name_native"));
        movie.setYearOfRelease(resultSet.getInt("year_of_release"));
        movie.setRating(resultSet.getDouble("movie_rate"));
        movie.setPrice(resultSet.getDouble("price"));
        movie.setPicturePath(resultSet.getString("poster_url"));
        return movie;
    }
}
