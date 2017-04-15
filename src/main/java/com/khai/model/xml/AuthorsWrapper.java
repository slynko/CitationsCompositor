package com.khai.model.xml;

import java.util.List;

public class AuthorsWrapper {

    private String condition;
    private String type;
    private int count;
    private String formattedBefore;
    private List<Author> authors;
    private String formattedAfter;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFormattedBefore() {
        return formattedBefore;
    }

    public void setFormattedBefore(String formattedBefore) {
        this.formattedBefore = formattedBefore;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getFormattedAfter() {
        return formattedAfter;
    }

    public void setFormattedAfter(String formattedAfter) {
        this.formattedAfter = formattedAfter;
    }

}
