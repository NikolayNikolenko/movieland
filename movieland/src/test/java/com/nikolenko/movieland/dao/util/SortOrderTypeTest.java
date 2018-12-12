package com.nikolenko.movieland.dao.util;

import com.nikolenko.movieland.dao.entity.SortOrderType;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SortOrderTypeTest {
    @Test
    public void testGetSortOrderType() {
        assertEquals("asc", SortOrderType.ASC.getSortOrderTypeName());
        assertEquals("desc", SortOrderType.DESC.getSortOrderTypeName());
        assertNotEquals("Asc", SortOrderType.ASC.getSortOrderTypeName());
    }

    ;

    @Test(expected = NoSuchElementException.class)
    public void testGetSortOrderTypeByNameException() {
        assertNotEquals(SortOrderType.ASC, SortOrderType.getSortOrderTypeByName("bsc"));
    }

    @Test
    public void testGetSortOrderTypeByName() {
        assertEquals(SortOrderType.ASC, SortOrderType.getSortOrderTypeByName("Asc"));
        assertEquals(SortOrderType.ASC, SortOrderType.getSortOrderTypeByName("asc"));
    }

}
