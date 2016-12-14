package com.khai.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest/bibliographies")
public class BibliographyService {

    private static List<String> bibliographies;

    public BibliographyService() {
        BibliographyService.bibliographies = getMockBibliographies();
    }

    @GetMapping
    public List<String> getAll() {
        return BibliographyService.bibliographies;
    }

    @PostMapping
    public void setAll(List<String> bibliographies) {
        BibliographyService.bibliographies = bibliographies;
    }

    @PostMapping
    @RequestMapping("/add")
    public void addBibliography(@RequestBody String bibliography) {
        BibliographyService.bibliographies.add(bibliography);
    }

    private  List<String> getMockBibliographies() {
        List<String> bibliographies = new ArrayList<>();

        bibliographies.add("Author L.L. 1990");
        bibliographies.add("Author D.D. 1991");
        bibliographies.add("Author S.S. 1992");
        bibliographies.add("Author Z.Z. 1993");
        bibliographies.add("Author K.K. 1993");

        return bibliographies;
    }
}
