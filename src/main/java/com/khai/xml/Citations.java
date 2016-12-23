package com.khai.xml;

public enum Citations {
    FIRST_AUTHOR("first-author"),
    TITLE("title"),
    EDITION_TYPE("edition-type"),
    TYPE("type"),
    ADDITIONAL_INFO("additional-info"),
    EDITORS("editors"),
    AUTHORS_AFTER("authors-after"),
    DIRECTORS("directors"),
    EXECUTORS("executors"),
    PUBLISHER_CITY("publisher-city"),
    PUBLISHER_NAME("publisher-name"),
    PUBLISHER("publisher"),
    YEAR_DATE("year-date"),
    VOLUME("volume"),
    NO("no"),
    PAGES("pages"),
    OFFICIAL_DATE("official-date");

    private String value;

    Citations(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Citations fromString(String text) {
        if (text != null) {
            for (Citations c : Citations.values()) {
                if (text.equalsIgnoreCase(c.getValue())) {
                    return c;
                }
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }

    @Override
    public String toString() {
        return getValue();
    }
}
