package com.khai.model;

import org.simpleframework.xml.Element;

public class Author {

    @Element(name = "name1")
    private Name name1;
    @Element(name = "name2")
    private Name name2;
    @Element(name = "surname")
    private Name surname;

}
