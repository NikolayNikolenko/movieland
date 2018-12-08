package com.nikolenko.movieland.dao.impl;

import com.nikolenko.movieland.dao.GenreDao;
import com.nikolenko.movieland.dao.entity.CacheStatus;
import com.nikolenko.movieland.dao.entity.GenreCache;
import com.nikolenko.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@Qualifier("CachedGenreDao")
public class CachedGenreDao implements GenreDao {
    private final Logger log = LoggerFactory.getLogger(getClass());
    GenreDao genreDao;
    GenreCache cache = GenreCache.getInstance();

    @Autowired
    public CachedGenreDao(@Qualifier("JdbcGenreDao") GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Scheduled(initialDelayString = "${scheduler.initial_time}", fixedDelayString = "${scheduler.delay_time}")
    @PostConstruct
    private void refreshCache() {
        cache.setCache(genreDao.getAll());
        cache.setStatus(CacheStatus.Available);
        log.info(" ================= Cache load was completed");
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> list;
        if (cache.getStatus() == CacheStatus.Available) {
            list = cache.getCache();
            log.info("  ==================  Query to get all genre from cache");
        } else {
            list = genreDao.getAll();
        }
        return list;
    }
}
