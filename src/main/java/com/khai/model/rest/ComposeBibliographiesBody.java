package com.khai.model.rest;

import lombok.Data;

import java.util.List;

@Data
public class ComposeBibliographiesBody {
    private List<String> bibliographyKeys;
    private String fileName;
    private String dstuType;
}
