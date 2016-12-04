package com.khai.xml;

import com.khai.model.Type;

import java.util.List;

public class Standard {

    private static Standard standard;
    private List<Type> types;

    private Standard() {
    }

    public static synchronized Standard getInstance() {
        if (standard == null) {
            standard = new Standard();
        }
        return standard;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

}
