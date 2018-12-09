package com.nikolenko.movieland.entity;

import com.nikolenko.movieland.dao.entity.SortOrderParameter;
import com.nikolenko.movieland.dao.entity.SortOrderType;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortOrderParameterTest {

    @Test
    public void testAdd () {
        Pair <String, SortOrderType> espectedPair = new Pair<String, SortOrderType>("price", SortOrderType.Asc);
        SortOrderParameter sortOrderParameter = new SortOrderParameter();
        sortOrderParameter.add("price", SortOrderType.Asc);
        sortOrderParameter.add("PRice", SortOrderType.Desc);
        assertEquals(2, sortOrderParameter.getSortOrderParameters().size());
        assertEquals(espectedPair, sortOrderParameter.getSortOrderParameters().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddException () {
        Pair <String, SortOrderType> espectedPair = new Pair<String, SortOrderType>("price", SortOrderType.Asc);
        SortOrderParameter sortOrderParameter = new SortOrderParameter();
        sortOrderParameter.add("inccorect_field", SortOrderType.Asc);
        assertEquals(1, sortOrderParameter.getSortOrderParameters().size());
        assertEquals(espectedPair, sortOrderParameter.getSortOrderParameters().get(0));
    }
}
