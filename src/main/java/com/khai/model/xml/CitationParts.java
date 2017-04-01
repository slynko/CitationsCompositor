package com.khai.model.xml;

import java.util.Map;

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

    public Map<String, Authors> getFirstAuthors() {
        return firstAuthors;
    }

    public void setFirstAuthors(Map<String, Authors> firstAuthors) {
        this.firstAuthors = firstAuthors;
    }

    public Map<String, Field> getTitles() {
        return titles;
    }

    public void setTitles(Map<String, Field> titles) {
        this.titles = titles;
    }

    public Map<String, Field> getEditionTypes() {
        return editionTypes;
    }

    public void setEditionTypes(Map<String, Field> editionTypes) {
        this.editionTypes = editionTypes;
    }

    public Map<String, Field> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Field> types) {
        this.types = types;
    }

    public Map<String, Field> getAdditionalInfos() {
        return additionalInfos;
    }

    public void setAdditionalInfos(Map<String, Field> additionalInfos) {
        this.additionalInfos = additionalInfos;
    }

    public Map<String, Authors> getEditors() {
        return editors;
    }

    public void setEditors(Map<String, Authors> editors) {
        this.editors = editors;
    }

    public Map<String, Authors> getAuthorsAfter() {
        return authorsAfter;
    }

    public void setAuthorsAfter(Map<String, Authors> authorsAfter) {
        this.authorsAfter = authorsAfter;
    }

    public Map<String, Authors> getDirectors() {
        return directors;
    }

    public void setDirectors(Map<String, Authors> directors) {
        this.directors = directors;
    }

    public Map<String, Authors> getExecutors() {
        return executors;
    }

    public void setExecutors(Map<String, Authors> executors) {
        this.executors = executors;
    }

    public Map<String, Field> getPublisherCities() {
        return publisherCities;
    }

    public void setPublisherCities(Map<String, Field> publisherCities) {
        this.publisherCities = publisherCities;
    }

    public Map<String, Field> getPublisherNames() {
        return publisherNames;
    }

    public void setPublisherNames(Map<String, Field> publisherNames) {
        this.publisherNames = publisherNames;
    }

    public Map<String, Field> getPublishers() {
        return publishers;
    }

    public void setPublishers(Map<String, Field> publishers) {
        this.publishers = publishers;
    }

    public Map<String, Field> getYearDates() {
        return yearDates;
    }

    public void setYearDates(Map<String, Field> yearDates) {
        this.yearDates = yearDates;
    }

    public Map<String, Field> getVolume() {
        return volume;
    }

    public void setVolume(Map<String, Field> volume) {
        this.volume = volume;
    }

    public Map<String, Field> getNo() {
        return no;
    }

    public void setNo(Map<String, Field> no) {
        this.no = no;
    }

    public Map<String, Field> getPages() {
        return pages;
    }

    public void setPages(Map<String, Field> pages) {
        this.pages = pages;
    }

    public Map<String, Field> getOfficialDates() {
        return officialDates;
    }

    public void setOfficialDates(Map<String, Field> officialDates) {
        this.officialDates = officialDates;
    }
}
