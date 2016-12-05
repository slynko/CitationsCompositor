package com.khai.xml;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class XmlController {

    public void test() {
//        Standard standard = Standard.getInstance();
        Serializer serializer = new Persister();
        File source = new File(this.getClass().getClassLoader().getResource("standard/dstu7.1.2006.xml").getFile());

        try {
            com.khai.model.Standard example = serializer.read(com.khai.model.Standard.class, source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
