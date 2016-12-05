package com.khai.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class MultipartSeparator {

    @Attribute(name = "name", required = false)
    private String name;

    @Attribute(name = "type", required = false)
    private String type;

    @ElementList(inline = true)
    private List<SeparatorItem> itemList;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<SeparatorItem> getItemList() {
        return itemList;
    }

}
