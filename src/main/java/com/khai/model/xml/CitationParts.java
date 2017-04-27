package com.khai.model.xml;

import lombok.Data;

import java.util.Map;

@Data
public class CitationParts {
    private Map<String, Authors> firstAuthors;
    private Map<String, Field> titles;
    private Map<String, Field> editionTypes;
    private Map<String, Field> types;
    private Map<String, Field> additionalInfos;
    private Map<String, Authors> editors;
    private Map<String, Authors> authorsAfter;
    private Map<String, Authors> directors;
    private Map<String, Authors> executors;
    private Map<String, Field> publisherCities;
    private Map<String, Field> publisherNames;
    private Map<String, Field> publishers;
    private Map<String, Field> yearDates;
    private Map<String, Field> volume;
    private Map<String, Field> no;
    private Map<String, Field> pages;
    private Map<String, Field> officialDates;
}
