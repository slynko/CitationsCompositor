package com.khai.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "type")
public class Type {

    @Element(name="name")
    private String name;

    @Element(name="title")
    private String title;


    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
