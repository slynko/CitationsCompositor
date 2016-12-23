package com.khai.model.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class MultipartSeparator {

    @Attribute(name = "name", required = false)
    private String name;
    @Attribute(name = "type", required = false)
    private String type;
    @ElementList(inline = true, required = false)
    private List<Separator> separators;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setSeparators(List<Separator> separators) {
        this.separators = separators;
    }

    public List<Separator> getSeparators() {
        return separators;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof MultipartSeparator)) {
            return false;
        }
        MultipartSeparator separator = (MultipartSeparator) o;
        return separator.name.equals(name) && separator.type.equals(type);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + separators.hashCode();
        return result;
    }

}
