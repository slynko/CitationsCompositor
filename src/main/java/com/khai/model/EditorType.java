package com.khai.model;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class EditorType {

    @ElementList(name = "separator-before")
    private List<SeparatorItem> separatorsBefore;
    @ElementList(name = "separator-after")
    private List<SeparatorItem> separatorsAfter;

    public List<SeparatorItem> getSeparatorsBefore() {
        return separatorsBefore;
    }

    public void setSeparatorsBefore(List<SeparatorItem> separatorsBefore) {
        this.separatorsBefore = separatorsBefore;
    }

    public List<SeparatorItem> getSeparatorsAfter() {
        return separatorsAfter;
    }

    public void setSeparatorsAfter(List<SeparatorItem> separatorsAfter) {
        this.separatorsAfter = separatorsAfter;
    }
}
