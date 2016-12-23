package com.khai.model.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Separator {

    @Attribute(name = "name")
    private String name;
    @Element(name = "default", required = false)
    private String symbolDef;
    @Element(name = "ru", required = false)
    private String symbolRu;
    @Element(name = "ua", required = false)
    private String symbolUa;
    @Element(name = "en", required = false)
    private String symbolEn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbolDef() {
        return symbolDef;
    }

    public void setSymbolDef(String symbolDef) {
        this.symbolDef = symbolDef;
    }

    public String getSymbolRu() {
        return symbolRu;
    }

    public void setSymbolRu(String symbolRu) {
        this.symbolRu = symbolRu;
    }

    public String getSymbolUa() {
        return symbolUa;
    }

    public void setSymbolUa(String symbolUa) {
        this.symbolUa = symbolUa;
    }

    public String getSymbolEn() {
        return symbolEn;
    }

    public void setSymbolEn(String symbolEn) {
        this.symbolEn = symbolEn;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Separator)) {
            return false;
        }
        Separator separator = (Separator) o;
        return separator.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + symbolDef.hashCode();
        result = 31 * result + symbolRu.hashCode();
        result = 31 * result + symbolUa.hashCode();
        result = 31 * result + symbolEn.hashCode();
        return result;
    }

}
