package com.nikolenko.movieland.dao.impl;

import com.nikolenko.movieland.dao.GenreDao;
import com.nikolenko.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@Qualifier("CachedGenreDao")
public class CachedGenreDao implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private volatile List<Genre> cache = new ArrayList<>();

    GenreDao genreDao;

    @Autowired
    public CachedGenreDao(@Qualifier("JdbcGenreDao") GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Scheduled(initialDelayString = "${scheduler.initial_time}", fixedDelayString = "${scheduler.delay_time}")
    @PostConstruct
    private void refreshCache() {
        cache.addAll(genreDao.getAll());
        log.info(" ================= Cache load was completed");
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> cacheCopy = new ArrayList<>(cache);
        log.info("  ==================  Query to get all genre from cache");
        return cacheCopy;
    }
}
