package com.nikolenko.movieland.dao.impl.jdbc;

import com.nikolenko.movieland.dao.MovieDao;
import com.nikolenko.movieland.dao.impl.jdbc.mapper.MovieRowMapper;
import com.nikolenko.movieland.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final MovieRowMapper MOVIE_ROW_MAPPER = new MovieRowMapper();
    private JdbcTemplate jdbcTemplate;

    private String getAllMovieSQL;
    private String getRandomMovieSQL;
    private String getMoviesByGenreSQL;

    public JdbcMovieDao() {
    }

    public List<Movie> getAllMovies() {
        log.info("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(getAllMovieSQL, MOVIE_ROW_MAPPER);
        log.info("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    public List<Movie> getRandomMovies() {
        log.info("Start query to get random movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(getRandomMovieSQL, MOVIE_ROW_MAPPER);
        log.info("Finish query to get random movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId) {
        log.info("Start query to get random movies from DB");
        long startTime = System.currentTimeMillis();
        List<Movie> movies = jdbcTemplate.query(getMoviesByGenreSQL, MOVIE_ROW_MAPPER, genreId) ;
        log.info("Finish query to get random movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return movies;

    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetAllMovieSQL(String getAllMovieSQL) {
        this.getAllMovieSQL = getAllMovieSQL;
    }

    @Autowired
    public void setGetRandomMovieSQL(String getRandomMovieSQL) {
        this.getRandomMovieSQL = getRandomMovieSQL;
    }

    @Autowired
    public void setGetMoviesByGenreSQL(String getMoviesByGenreSQL) {
        this.getMoviesByGenreSQL = getMoviesByGenreSQL;
    }
}
