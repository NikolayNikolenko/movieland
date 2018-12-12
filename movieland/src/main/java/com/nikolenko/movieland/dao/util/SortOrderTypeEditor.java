package com.nikolenko.movieland.dao.util;

import com.nikolenko.movieland.dao.entity.SortOrderType;

import java.beans.PropertyEditorSupport;

public class SortOrderTypeEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        SortOrderType sortOrderType = (SortOrderType) getValue();

        return sortOrderType == null ? "" : sortOrderType.getSortOrderTypeName();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SortOrderType sortOrderType = SortOrderType.getSortOrderTypeByName(text);
        setValue(sortOrderType);
    }
}
