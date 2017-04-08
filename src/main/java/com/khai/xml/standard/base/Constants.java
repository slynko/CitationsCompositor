package com.khai.xml.standard.base;

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
    }

}
