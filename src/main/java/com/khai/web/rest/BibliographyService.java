package com.khai.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest/bibliographies")
public class BibliographyService {

    @GetMapping
    public List<String> getAll() {
        String formattedStringOne = "1 Author L.L. 1990";
        String formattedStringTwo = "2 Author B.B. 1555";
        String formattedStringThree = "3 Author B.B. 1999";

        List<String> standards = new ArrayList<>();
        standards.add(formattedStringOne);
        standards.add(formattedStringTwo);
        standards.add(formattedStringThree);

        return standards;
    }


}
