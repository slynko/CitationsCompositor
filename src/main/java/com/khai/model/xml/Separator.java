package com.khai.model.xml;

import lombok.Data;

@Data
public class Separator {
    private String symbolDef;
    private String symbolRu;
    private String symbolUa;
    private String symbolEn;

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + symbolDef.hashCode();
        result = 31 * result + symbolRu.hashCode();
        result = 31 * result + symbolUa.hashCode();
        result = 31 * result + symbolEn.hashCode();
        return result;
    }

}
