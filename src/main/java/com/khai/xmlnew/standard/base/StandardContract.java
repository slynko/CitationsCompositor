package com.khai.xmlnew.standard.base;

import com.khai.db.model.CitationModel;

import java.util.Map;

public interface StandardContract {

    /**
     * Method for initiating making of standard
     */
    void make();

    /**
     * Get types of standard
     * @return {@link Map} of keys and titles of types for displaying
     */
    Map<String, String> getTypes();

    /**
     * Returns string citation based on inputted model and its type
     * @param citationModel citation model which will be converted
     * @param type type of citation
     * @return string representation of citation model`
     */
    String getCitation(CitationModel citationModel, String type);

}
