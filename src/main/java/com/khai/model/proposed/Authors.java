package com.khai.model.proposed;

import com.khai.model.EditorType;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class Authors {

    @Attribute(name = "no", required = false)
    private String no;
    @Attribute(name = "type", required = false)
    private String type;
    @ElementList(name = "author", inline = true, required = false)
    private List<Author> authors;
    @Element(name = "editor-type", required = false)
    private EditorType editorType;
    @Element(name = "multipart-separator-after", required = false)
    private String multipartSeparatorAfter;

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

    public String getMultipartSeparatorAfter() {
        return multipartSeparatorAfter;
    }

    public void setMultipartSeparatorAfter(String multipartSeparatorAfter) {
        this.multipartSeparatorAfter = multipartSeparatorAfter;
    }
}
