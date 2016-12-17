package com.khai.xml;

import com.khai.model.Standard;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.net.URL;

public class XmlController {

    public void test() {
        URL path = getClass().getClassLoader().getResource("standard/dstu7.1.2006.xml");
        if (path == null) return;
        Serializer serializer = new Persister();
        File source = new File(path.getFile());
        try {
            Standard stadard = serializer.read(Standard.class, source);
            System.out.println("Debug point\nEverything is ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
