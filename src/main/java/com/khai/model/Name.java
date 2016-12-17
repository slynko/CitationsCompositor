package com.khai.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class Name {

    @Element(name = "unique")
    private boolean unique;
    @Element(name = "len")
    private int len;
    @ElementList(name = "separator-after", required = false)
    private List<SeparatorItem> separatorItems;

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

    public List<SeparatorItem> getSeparatorItems() {
        return separatorItems;
    }

    public void setSeparatorItems(List<SeparatorItem> separatorItems) {
        this.separatorItems = separatorItems;
    }

}
