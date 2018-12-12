package com.nikolenko.movieland.dao.util;

import com.nikolenko.movieland.dao.entity.SortOrderParameter;
import com.nikolenko.movieland.dao.entity.SortOrderType;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuerySortSQLBuilder {

    public String getQueryText(String queryText, SortOrderParameter sortOrderParameter) {
        StringBuilder builder = new StringBuilder();
        // sql + ' order by ' + price + ' ' + 'asc' + ', '
        builder.append(queryText);
        List<Pair<String, SortOrderType>> parameters = sortOrderParameter.getSortOrderParameters();
        if (sortOrderParameter.getSortOrderParameters().size() > 0) {
            builder.append(" order by ");
            String separator = "";
            for (Pair<String, SortOrderType> parameter : parameters) {
                builder.append(separator);
                builder.append(parameter.getKey());
                builder.append(" ");
                builder.append(parameter.getValue().getSortOrderTypeName());
                separator = ", ";
            }
        }
        return builder.toString();
    }
}