package com.nikolenko.movieland.dao.util;

import com.nikolenko.movieland.dao.entity.SortOrderParameter;
import com.nikolenko.movieland.dao.entity.SortOrderType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuerySortSQLBuilderTest {
    @Test
    public void testGetQueryTextWithTwoSortOrderParameters() {
        SortOrderParameter sortOrderParameter = new SortOrderParameter();
        sortOrderParameter.add("price", SortOrderType.ASC);
        sortOrderParameter.add("movie_rate", SortOrderType.DESC);
        QuerySortSQLBuilder querySortSQLBuilder = new QuerySortSQLBuilder();
        assertEquals("select * from table order by price asc, movie_rate desc",
                querySortSQLBuilder.getQueryText("select * from table", sortOrderParameter));

    }

    @Test
    public void testGetQueryTextWithOneSortOrderParameter() {
        SortOrderParameter sortOrderParameter = new SortOrderParameter();
        sortOrderParameter.add("price", SortOrderType.ASC);
        QuerySortSQLBuilder querySortSQLBuilder = new QuerySortSQLBuilder();
        assertEquals("select * from table order by price asc",
                querySortSQLBuilder.getQueryText("select * from table", sortOrderParameter));

    }

}
