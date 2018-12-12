package com.nikolenko.movieland.dao.entity;

import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SortOrderParameter {
    List<Pair<String, SortOrderType>> sortOrderParameters;
    List<Pair<String, SortOrderType>> validationList;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public SortOrderParameter() {
        sortOrderParameters = new ArrayList<>();
        validationList = new ArrayList<>();
        validationList.add(new Pair<String, SortOrderType>("movie_rate", SortOrderType.DESC));
        validationList.add(new Pair<String, SortOrderType>("price", SortOrderType.ASC));
        validationList.add(new Pair<String, SortOrderType>("price", SortOrderType.DESC));
    }

    public void add(String fieldName, SortOrderType sortOrderType) {
        Pair<String, SortOrderType> parameter = new Pair<>(fieldName.trim().toLowerCase(), sortOrderType);
        for (Pair<String, SortOrderType> validator : validationList) {
            if (validator.equals(parameter)) {
                sortOrderParameters.add(parameter);
                return;
            }
        }
        log.info("Not suported combination of name: {} and order: {}", fieldName, sortOrderType.getSortOrderTypeName());
        throw new IllegalArgumentException("Not suported combination of name: " + fieldName + " and order: " + sortOrderType.getSortOrderTypeName());
    }

    public List<Pair<String, SortOrderType>> getSortOrderParameters() {
        return sortOrderParameters;
    }
}
