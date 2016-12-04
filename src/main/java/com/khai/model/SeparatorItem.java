package com.khai.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root
public class SeparatorItem {

    @Attribute(name = "name")
    private String name;

    public String getName() {
        return name;
    }

}
