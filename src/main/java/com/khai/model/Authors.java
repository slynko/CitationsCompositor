package com.khai.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class Authors {

    @Attribute(name = "name", required = false)
    private String name;
    @Attribute(name = "no", required = false)
    private String no;
    @Attribute(name = "type", required = false)
    private String type;
    @ElementList(name = "author", inline = true, required = false)
    private List<Author> authors;
    @Element(name = "editor-type", required = false)
    private EditorType editorType;
    @ElementList(name = "separator-after", required = false)
    private List<SeparatorItem> separatorsAfter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public EditorType getEditorType() {
        return editorType;
    }

    public void setEditorType(EditorType editorType) {
        this.editorType = editorType;
    }

    public List<SeparatorItem> getSeparatorsAfter() {
        return separatorsAfter;
    }

    public void setSeparatorsAfter(List<SeparatorItem> separatorsAfter) {
        this.separatorsAfter = separatorsAfter;
    }
}
