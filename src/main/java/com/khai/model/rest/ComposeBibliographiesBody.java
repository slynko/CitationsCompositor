package com.khai.model.rest;

import java.util.List;

public class ComposeBibliographiesBody {
    private List<String> bibliographyKeys;
    private String fileName;

    public List<String> getBibliographyKeys() {
        return bibliographyKeys;
    }

    public void setBibliographyKeys(List<String> bibliographyKeys) {
        this.bibliographyKeys = bibliographyKeys;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
