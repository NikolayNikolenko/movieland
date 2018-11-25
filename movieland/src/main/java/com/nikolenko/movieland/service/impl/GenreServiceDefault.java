package com.nikolenko.movieland.service.impl;

import com.nikolenko.movieland.dao.GenreDao;
import com.nikolenko.movieland.entity.Genre;
import com.nikolenko.movieland.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreServiceDefault implements GenreService {
    private GenreDao genreDao;

    @Autowired
    public GenreServiceDefault(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
