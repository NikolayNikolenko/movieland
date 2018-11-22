package com.nikolenko.movieland.dao.jdbc;

import com.nikolenko.movieland.dao.jdbc.mapper.MovieDao;
import com.nikolenko.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.nikolenko.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao  {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String getAllMovieSQL;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    public void setGetAllMovieSQL(String getAllMovieSQL) {
        this.getAllMovieSQL = getAllMovieSQL;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Movie> getAllMovies() {
        log.info("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(getAllMovieSQL, new MovieRowMapper());
        log.info("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }
}
