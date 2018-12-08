package com.nikolenko.movieland.dao.impl.jdbc;


import com.nikolenko.movieland.dao.GenreDao;
import com.nikolenko.movieland.dao.impl.jdbc.mapper.GenreRowMapper;
import com.nikolenko.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("JdbcGenreDao")
public class JdbcGenreDao  implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private JdbcTemplate jdbcTemplate;

    private String getAllGenreSQL;

    public JdbcGenreDao() {
    }

    public List<Genre> getAll () {
        log.info("Start query to get all movies from DB");
        long startTime = System.currentTimeMillis();
        List<Genre> genres = jdbcTemplate.query(getAllGenreSQL, GENRE_ROW_MAPPER);
        log.info("Finish query to get all movies from DB. It took {} ms", System.currentTimeMillis() - startTime);
        return genres;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetAllGenreSQL(String getAllGenreSQL) {
        this.getAllGenreSQL = getAllGenreSQL;
    }

}
