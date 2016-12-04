package com.khai.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Separator {

    @Attribute(name = "name")
    private String name;

    @Element(name = "default", required = false)
    private String symbolDef;

    @Element(name = "ru", required = false)
    private String symbolRu;

    @Element(name = "ua", required = false)
    private String symbolUa;

    @Element(name = "en", required = false)
    private String symbolEn;

}
