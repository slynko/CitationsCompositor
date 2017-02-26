package com.khai.xmlnew.standard.base;

import com.khai.db.model.CitationModel;

import java.util.Map;

public interface StandardContract {

    void make();

    Map<String, String> getTypes();

    String getCitation(CitationModel citationModel, String type);

}
