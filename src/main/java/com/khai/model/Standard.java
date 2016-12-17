package com.khai.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "standard")
public class Standard {

    @Attribute(name = "name")
    private String name;
    @Attribute(name = "title")
    private String title;
    @ElementList(name = "types")
    private List<Type> typeList;
    @ElementList(name = "separators")
    private List<Separator> separatorList;
    @ElementList(name = "multipart-separators", required = false)
    private List<MultipartSeparator> multiSeparatorList;
    @ElementList(name = "names", required = false)
    private List<Authors> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public List<Separator> getSeparatorList() {
        return separatorList;
    }

    public void setSeparatorList(List<Separator> separatorList) {
        this.separatorList = separatorList;
    }

    public List<MultipartSeparator> getMultiSeparatorList() {
        return multiSeparatorList;
    }

    public void setMultiSeparatorList(List<MultipartSeparator> multiSeparatorList) {
        this.multiSeparatorList = multiSeparatorList;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }
}
