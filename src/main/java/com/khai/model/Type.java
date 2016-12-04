package com.khai.model;

import org.simpleframework.xml.Attribute;

public class Type {

    @Attribute(name="name")
    private String name;

    @Attribute(name="title")
    private String title;


    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
