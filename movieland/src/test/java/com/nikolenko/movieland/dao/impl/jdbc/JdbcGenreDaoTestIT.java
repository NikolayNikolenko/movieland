package com.nikolenko.movieland.dao.impl.jdbc;

import com.nikolenko.movieland.dao.GenreDao;
import com.nikolenko.movieland.entity.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml", "file:src/main/webapp/WEB-INF/movieland-servlet.xml", "classpath:/spring/test-context.xml"})
public class JdbcGenreDaoTestIT {
    @Autowired
    @Qualifier("CachedGenreDao")
    private GenreDao genreDao;

    @Test
    public void getAllGenres() {
        Genre expectedGenre = new Genre();
        expectedGenre.setId(1);
        expectedGenre.setName("драма");

        List<Genre> actualGenreList = genreDao.getAll();
        assertEquals(3, actualGenreList.size());
        int index = actualGenreList.indexOf(expectedGenre);
        Genre actualGenre = actualGenreList.get(index);

        assertEquals(expectedGenre.getId(), actualGenre.getId());
        assertEquals(expectedGenre.getName(), actualGenre.getName());

        actualGenreList = genreDao.getAll();
        assertEquals(3, actualGenreList.size());
        index = actualGenreList.indexOf(expectedGenre);
        actualGenre = actualGenreList.get(index);

        assertEquals(expectedGenre.getId(), actualGenre.getId());
        assertEquals(expectedGenre.getName(), actualGenre.getName());

    }
}

