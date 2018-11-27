package com.nikolenko.movieland.controller;

import com.nikolenko.movieland.entity.Movie;
import com.nikolenko.movieland.service.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
@WebAppConfiguration
public class MovieControllerTest extends AbstractJUnit4SpringContextTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MovieService movieService;

    private Movie movie;

    @Before
    public void setUp() {
        Mockito.reset(movieService);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        movie = new Movie();
        movie.setId(1);
        movie.setNameRussian("Список Шиндлера");
        movie.setNameNative("Schindler's List");
        movie.setYearOfRelease(1993);
        movie.setRating(8.7);
        movie.setPrice(150.5);
        movie.setPicturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg");
    }
    @Test
    public void testGetAllMovies() throws Exception {
        // Prepare
        // When
        when(movieService.getAll()).thenReturn(Collections.singletonList(movie));
        // Then
        mockMvc.perform(get("/v1/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1993)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")));
    }
    @Test
    public void testGetRandomMovies() throws Exception {
        // Prepare
        when(movieService.getRandom()).thenReturn(Collections.singletonList(movie));
        // Then
        mockMvc.perform(get("/v1/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Список Шиндлера")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Schindler's List")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1993)))
                .andExpect(jsonPath("$[0].rating", equalTo(8.7)))
                .andExpect(jsonPath("$[0].price", equalTo(150.5)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg")));
    }

}
