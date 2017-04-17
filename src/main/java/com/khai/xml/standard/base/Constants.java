package com.khai.xml.standard.base;

public final class Constants {

    private Constants(){}

    /**
     * Names of standards
     */
    public interface StandardName {
        String DSTU_7_1_2006 = "dstu7.1.2006.xml";
    }

    /**
     * Paths to standard
     */
    public interface StandardPath {
        String DSTU_7_1_2006 = "standard/dstu7.1.2006.xml";
    }

    /**
     * Nodes of standards in XML documents
     */
    public interface XmlNode {
        String NAME = "name";
        String DEFAULT = "default";
        String RU = "ru";
        String UA = "ua";
        String EN = "en";
        String SEPARATOR = "separator";
        String MULTIPART_SEPARATOR_BEFORE = "multipart-separator-before";
        String MULTIPART_SEPARATOR_AFTER = "multipart-separator-after";
        String STRING = "string";
        String AUTHOR_PART = "author-part";
        String AUTHOR = "author";
    }


    /**
     * Paths to nodes of standards in XML documents
     */
    public interface XmlPathToNode {
        String TYPES = "/standard/types/type";
        String SEPARATORS = "/standard/separators/separator";
        String MULTIPART_SEPARATORS_BEFORE = "/standard/multipart-separators-before/multipart-separator";
        String MULTIPART_SEPARATORS_AFTER = "/standard/multipart-separators-after/multipart-separator";
        String CITATION_PARTS_PART = "/standard/citation-parts/part";
        String CITATIONS_CITATION = "/standard/citations/citation";
    }

    /**
     * Names of XML attributes of standards
     */
    public interface XmlAttribute {
        String TITLE = "@title";
        String NAME = "@name";
        String TYPE = "@type";
        String CONTENT_TYPE = "@contentType";
        String CONDITION = "@condition";
        String COUNT = "@count";
        String LEN = "@len";
    }

    public interface Tags {
        String FIRST_AUTHOR = "first-author";
        String TITLE = "title";
        String TYPE = "type";
        String EDITION_TYPE = "edition-type";
        String AUTHORS_AFTER = "authors-after";
        String PUBLISHER = "publisher";
        String EDITORS = "editors";
        String DIRECTORS = "directors";
        String PUBLISHER_CITY = "publisher-city";
        String PUBLISHER_NAME = "publisher-name";
        String YEAR_DATE = "year-date";
        String VOLUME = "volume";
        String NO = "no";
        String PAGES = "pages";
    }

    public interface Conditions {
        String EQUAL = "eq";            //equal to                 - "==" - "eq"
        String NOT_EQUAL = "ne";        //not equal to             - "!=" - "ne"
        String GREATER_THAN = "gt";     //greater than             - ">"  - "gt"
        String LESS_THAN = "lt";        //less than                - "<"  - "lt"
        String GREATER_OR_EQUAL = "gq"; //greater than or equal to - ">=" - "gq"
        String LESS_OR_EQUAL = "lq";    //less than or equal to    - "<=" - "lq"
    }
}
