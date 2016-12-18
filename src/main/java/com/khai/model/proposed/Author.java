package com.khai.model.proposed;

import org.simpleframework.xml.Element;

public class Author {

    @Element(name = "name1")
    private Name name1;
    @Element(name = "name2")
    private Name name2;
    @Element(name = "surname")
    private Name surname;

    public Name getName1() {
        return name1;
    }

    public void setName1(Name name1) {
        this.name1 = name1;
    }

    public Name getName2() {
        return name2;
    }

    public void setName2(Name name2) {
        this.name2 = name2;
    }

    public Name getSurname() {
        return surname;
    }

    public void setSurname(Name surname) {
        this.surname = surname;
    }
}
