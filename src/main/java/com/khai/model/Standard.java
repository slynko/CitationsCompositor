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

    // TODO: 12/5/2016 might don't exist
    @ElementList(name = "multipart-separators")
    private List<MultipartSeparator> multiSeparatorList;

}
