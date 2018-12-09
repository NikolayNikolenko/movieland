package com.nikolenko.movieland.dao.util;

import com.nikolenko.movieland.dao.entity.SortOrderType;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SortOrderTypeTest {
    @Test
    public void testGetSortOrderType(){
        assertEquals("asc", SortOrderType.Asc.getSortOrderTypeName());
        assertEquals( "desc", SortOrderType.Desc.getSortOrderTypeName());
        assertNotEquals("Asc", SortOrderType.Asc.getSortOrderTypeName());
    };

    @Test(expected = NoSuchElementException.class)
    public void testGetSortOrderTypeByNameException() {
        assertNotEquals(SortOrderType.Asc, SortOrderType.getSortOrderTypeByName("bsc"));
    }

    @Test
    public void testGetSortOrderTypeByName () {
        assertEquals(SortOrderType.Asc, SortOrderType.getSortOrderTypeByName("Asc"));
        assertEquals(SortOrderType.Asc, SortOrderType.getSortOrderTypeByName("asc"));
    }

}
