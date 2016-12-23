package com.khai.model.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementArray;

public class Citation {

    @Attribute(name = "type")
    private String type;
    @ElementArray(name = "parts")
    private String[] parts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getParts() {
        return parts;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }
}
