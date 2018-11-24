package com.nikolenko.movieland.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {
    public Movie movie;

    public MovieTest() {
        movie = new Movie();
        movie.setNameRussian("Тестовое название");
    }
    @Test
    public void testGetNameRussian() {
        assertEquals("Тестовое название",movie.getNameRussian());
        assertNotEquals("Неверное тестовое название",movie.getNameRussian());

    }
}
