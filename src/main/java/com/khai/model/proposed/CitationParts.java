package com.khai.model.proposed;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class CitationParts {

    @ElementList(name = "first-author")
    private List<Authors> firstAuthors;
    @ElementList(name = "title")
    private List<Field> titles;
    @ElementList(name = "edition-type")
    private List<Field> editionTypes;
    @ElementList(name = "type")
    private List<Field> types;
    @ElementList(name = "additional-info")
    private List<Field> additionalInfos;
    @ElementList(name = "editors")
    private List<Authors> editors;
    @ElementList(name = "authors-after")
    private List<Authors> authorsAfter;
    @ElementList(name = "directors")
    private List<Authors> directors;
    @ElementList(name = "executors")
    private List<Authors> executors;
    @ElementList(name = "publisher-city")
    private List<Field> publisherCities;
    @ElementList(name = "publisher-name")
    private List<Field> publisherNames;
    @ElementList(name = "publisher")
    private List<Field> publishers;
    @ElementList(name = "year-date")
    private List<Field> yearDates;
    @ElementList(name = "volume")
    private List<Field> volume;
    @ElementList(name = "no")
    private List<Field> no;
    @ElementList(name = "pages")
    private List<Field> pages;
    @ElementList(name = "official-date")
    private List<Field> officialDates;

    public List<Authors> getFirstAuthors() {
        return firstAuthors;
    }

    public void setFirstAuthors(List<Authors> firstAuthors) {
        this.firstAuthors = firstAuthors;
    }

    public List<Field> getTitles() {
        return titles;
    }

    public void setTitles(List<Field> titles) {
        this.titles = titles;
    }

    public List<Field> getEditionTypes() {
        return editionTypes;
    }

    public void setEditionTypes(List<Field> editionTypes) {
        this.editionTypes = editionTypes;
    }

    public List<Field> getTypes() {
        return types;
    }

    public void setTypes(List<Field> types) {
        this.types = types;
    }

    public List<Field> getAdditionalInfos() {
        return additionalInfos;
    }

    public void setAdditionalInfos(List<Field> additionalInfos) {
        this.additionalInfos = additionalInfos;
    }

    public List<Authors> getEditors() {
        return editors;
    }

    public void setEditors(List<Authors> editors) {
        this.editors = editors;
    }

    public List<Authors> getAuthorsAfter() {
        return authorsAfter;
    }

    public void setAuthorsAfter(List<Authors> authorsAfter) {
        this.authorsAfter = authorsAfter;
    }

    public List<Authors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Authors> directors) {
        this.directors = directors;
    }

    public List<Authors> getExecutors() {
        return executors;
    }

    public void setExecutors(List<Authors> executors) {
        this.executors = executors;
    }

    public List<Field> getPublisherCities() {
        return publisherCities;
    }

    public void setPublisherCities(List<Field> publisherCities) {
        this.publisherCities = publisherCities;
    }

    public List<Field> getPublisherNames() {
        return publisherNames;
    }

    public void setPublisherNames(List<Field> publisherNames) {
        this.publisherNames = publisherNames;
    }

    public List<Field> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Field> publishers) {
        this.publishers = publishers;
    }

    public List<Field> getYearDates() {
        return yearDates;
    }

    public void setYearDates(List<Field> yearDates) {
        this.yearDates = yearDates;
    }

    public List<Field> getVolume() {
        return volume;
    }

    public void setVolume(List<Field> volume) {
        this.volume = volume;
    }

    public List<Field> getNo() {
        return no;
    }

    public void setNo(List<Field> no) {
        this.no = no;
    }

    public List<Field> getPages() {
        return pages;
    }

    public void setPages(List<Field> pages) {
        this.pages = pages;
    }

    public List<Field> getOfficialDates() {
        return officialDates;
    }

    public void setOfficialDates(List<Field> officialDates) {
        this.officialDates = officialDates;
    }
}
