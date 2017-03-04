package com.khai.xmlnew.standard.base;

public final class Constants {

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
        String NAME1 = "name1";
        String NAME2 = "name2";
        String SURNAME = "surname";
        String MULTIPART_SEPARATOR_BEFORE = "multipart-separator-before";
        String MULTIPART_SEPARATOR_AFTER = "multipart-separator-after";
        String STRING = "string";
    }


    /**
     * Paths to nodes of standards in XML documents
     */
    public interface XmlPathToNode {
        String TYPES = "/standard/types/type";
        String SEPARATORS = "/standard/separators/separator";
        String MULTIPART_SEPARATORS_BEFORE = "/standard/multipart-separators-before/multipart-separator";
        String MULTIPART_SEPARATORS_AFTER = "/standard/multipart-separators-after/multipart-separator";
        String CITATION_PARTS_FIRST_AUTHOR = "/standard/citation-parts/first-author/authors";
        String CITATION_PARTS_TITLE = "/standard/citation-parts/title/field";
        String CITATION_PARTS_EDITION_TYPE = "/standard/citation-parts/edition-type/field";
        String CITATION_PARTS_TYPE = "/standard/citation-parts/type/field";
        String CITATION_PARTS_ADDITIONAL_INFO = "/standard/citation-parts/additional-info/field";
        String CITATION_PARTS_EDITORS = "/standard/citation-parts/editors/authors";
        String CITATION_PARTS_AUTHORS_AFTER = "/standard/citation-parts/authors-after/authors";
        String CITATION_PARTS_DIRECTORS = "/standard/citation-parts/directors/authors";
        String CITATION_PARTS_EXECUTORS = "/standard/citation-parts/executors/authors";
        String CITATION_PARTS_PUBLISHER_CITY = "/standard/citation-parts/publisher-city/field";
        String CITATION_PARTS_PUBLISHER_NAME = "/standard/citation-parts/publisher-name/field";
        String CITATION_PARTS_PUBLISHER = "/standard/citation-parts/publisher/field";
        String CITATION_PARTS_YEAR_DATE = "/standard/citation-parts/year-date/field";
        String CITATION_PARTS_VOLUME = "/standard/citation-parts/volume/field";
        String CITATION_PARTS_NO = "/standard/citation-parts/no/field";
        String CITATION_PARTS_PAGES = "/standard/citation-parts/pages/field";
        String CITATION_PARTS_OFFICIAL_DATE = "/standard/citation-parts/official-date/field";
        String CITATIONS_CITATION = "/standard/citations/citation";
    }

    /**
     * Names of XML attributes of standards
     */
    public interface XmlAttribute {
        String TITLE = "@title";
        String NAME = "@name";
        String TYPE = "@type";
        String CONDITION = "@condition";
    }

}
