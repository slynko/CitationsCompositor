package com.khai.web.rest;

import com.khai.model.Standard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class XmlEntityController {
    @RequestMapping("/entities")
    public List<Standard> index() {
        Standard standard1 = new Standard();
        standard1.setTitle("Test title1");
        Standard standard2 = new Standard();
        standard2.setTitle("Test title2");

        List<Standard> standards = new ArrayList<Standard>();
        standards.add(standard1);
        standards.add(standard2);

        return standards;
    }
}
