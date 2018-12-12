package com.nikolenko.movieland.controller;

import com.nikolenko.movieland.entity.Genre;
import com.nikolenko.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GenreController {
    private GenreService genreService;

    @RequestMapping(method = RequestMethod.GET, path = "/v1/genre", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
}
