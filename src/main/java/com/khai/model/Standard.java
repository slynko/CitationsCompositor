package com.khai.model;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "standard")
public class Standard {

    @ElementList(name = "types")
    List<Type> typeList;

}
