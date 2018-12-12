package com.nikolenko.movieland.dao.entity;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum SortOrderType {
    ASC("asc"), DESC("desc");

    private static final Map<String, SortOrderType> lookup = new HashMap<String, SortOrderType>();

    private final String sortOrderTypeName;

    static {
        for (SortOrderType sortOrderType : EnumSet.allOf(SortOrderType.class))
            lookup.put(sortOrderType.name().toLowerCase(), sortOrderType);

    }

    public static SortOrderType getSortOrderTypeByName(String name) //throws IllegalArgumentException
    {
        SortOrderType element = lookup.get(name.trim().toLowerCase());
        if (element == null)
            throw new NoSuchElementException(" ======= Sort Order has invalid Value " + name.trim());
        return element;
    }

    SortOrderType(String sortOrderType) {
        this.sortOrderTypeName = sortOrderType;
    }

    public String getSortOrderTypeName() {
        return sortOrderTypeName;
    }
}
