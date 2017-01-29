package com.khai.xmlnew.standard.base;

import com.khai.db.model.CitationModel;

import java.util.List;

public interface StandardContract {

    void make();

    List<String> getTypes();

    String getCitation(CitationModel citationModel);

}
