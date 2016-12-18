package com.khai.model.proposed;

import org.simpleframework.xml.Element;

public class Name {

    @Element(name = "unique")
    private boolean unique;
    @Element(name = "len")
    private int len;
    @Element(name = "multipart-separator-after", required = false)
    private String separator;

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
