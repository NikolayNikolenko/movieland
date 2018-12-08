package com.nikolenko.movieland.dao.entity;

import com.nikolenko.movieland.entity.Genre;

import java.util.Collections;
import java.util.List;

public class GenreCache {
    List<Genre> cache;
    CacheStatus status;


    private GenreCache() {
        this.status = CacheStatus.Inaccessible;
    }

    public static GenreCache getInstance() {
        return GenreCacheSingeltonHolder.instance;
    }

    public void setStatus(CacheStatus status) {
        this.status = status;
    }

    public void setCache(List<Genre> cache) {
        this.cache = cache;
    }

    public List<Genre> getCache() {
        return Collections.unmodifiableList(cache);
    }

    public CacheStatus getStatus() {
        return status;
    }

    private static class GenreCacheSingeltonHolder {
        static GenreCache instance = new GenreCache();
    }


}
