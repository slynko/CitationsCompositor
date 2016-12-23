package com.khai.model.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
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
    @ElementList(name = "multipart-separators-before", required = false)
    private List<MultipartSeparator> multiSeparatorsBefore;
    @ElementList(name = "multipart-separators-after", required = false)
    private List<MultipartSeparator> multiSeparatorsAfter;
    @Element(name = "citation-parts", required = false)
    private CitationParts citationParts;
    @ElementList(name = "citations", required = false)
    private List<Citation> citations;

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

    public List<MultipartSeparator> getMultiSeparatorsBefore() {
        return multiSeparatorsBefore;
    }

    public void setMultiSeparatorsBefore(List<MultipartSeparator> multiSeparatorsBefore) {
        this.multiSeparatorsBefore = multiSeparatorsBefore;
    }

    public List<MultipartSeparator> getMultiSeparatorsAfter() {
        return multiSeparatorsAfter;
    }

    public void setMultiSeparatorsAfter(List<MultipartSeparator> multiSeparatorsAfter) {
        this.multiSeparatorsAfter = multiSeparatorsAfter;
    }

    public CitationParts getCitationParts() {
        return citationParts;
    }

    public void setCitationParts(CitationParts citationParts) {
        this.citationParts = citationParts;
    }

    public List<Citation> getCitations() {
        return citations;
    }

    public void setCitations(List<Citation> citations) {
        this.citations = citations;
    }
}
