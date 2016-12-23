package com.khai.model.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Field {

    @Attribute(name = "type")
    private String type;
    @Element(name = "multipart-separator-before", required = false)
    private MultipartSeparator multipartSeparatorBefore;
    @Element(name = "info", required = false)
    private String info;
    @Element(name = "multipart-separator-after", required = false)
    private MultipartSeparator multipartSeparatorAfter;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartSeparator getMultipartSeparatorBefore() {
        return multipartSeparatorBefore;
    }

    public void setMultipartSeparatorBefore(MultipartSeparator multipartSeparatorBefore) {
        this.multipartSeparatorBefore = multipartSeparatorBefore;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public MultipartSeparator getMultipartSeparatorAfter() {
        return multipartSeparatorAfter;
    }

    public void setMultipartSeparatorAfter(MultipartSeparator multipartSeparatorAfter) {
        this.multipartSeparatorAfter = multipartSeparatorAfter;
    }
}
