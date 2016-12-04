package com.khai.xml;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.InputNode;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlController {

    public void test() throws ParserConfigurationException, IOException, SAXException {
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
