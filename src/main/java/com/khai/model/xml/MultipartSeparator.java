package com.khai.model.xml;

import lombok.Data;

@Data
public class MultipartSeparator {
    private String name;
    private String type;
    private String value;

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
        result = 31 * result + value.hashCode();
        return result;
    }

}
