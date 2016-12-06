package com.khai.web.rest;

import com.khai.model.Standard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlEntityController {
    @RequestMapping("/entities")
    public Standard index() {
        Standard standard = new Standard();
        standard.setTitle("Test title");
        return standard;
    }
}
