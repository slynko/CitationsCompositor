package com.khai.xml;

import com.khai.model.Standard;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.net.URL;

public class XmlController {

    private static final String STANDARD_PATH = "standard/dstu7.1.2006.xml";
    private static final String STANDARD_PROPOSED_PATH = "standard/dstu7.1.2006_PROPOSED.xml";

    public void test() {
        URL path = getClass().getClassLoader().getResource(STANDARD_PATH);
        //URL path = getClass().getClassLoader().getResource(STANDARD_PROPOSED_PATH);
        if (path == null) return;
        Serializer serializer = new Persister();
        File source = new File(path.getFile());
        try {
            Standard standard = serializer.read(Standard.class, source);
            //StandardProposed standard = serializer.read(StandardProposed.class, source);
            System.out.println("Debug point\nEverything is ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
