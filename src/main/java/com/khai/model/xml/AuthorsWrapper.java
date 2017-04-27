package com.khai.model.xml;

import lombok.Data;

import java.util.List;

@Data
public class AuthorsWrapper {
    private String condition;
    private String type;
    private int count;
    private String formattedBefore;
    private List<Author> authors;
    private String formattedAfter;
}
