package com.khai.xml;

import com.khai.model.xml.Standard;
import com.khai.utils.StandardUtils;
import com.sun.istack.internal.Nullable;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.net.URL;

/**
 * Parser for xml files of standard
 */
public class XmlParser {

    private static XmlParser controller;

    private XmlParser() {
    }

    public static synchronized XmlParser getInstance() {
        if (controller == null) {
            controller = new XmlParser();
        }
        return controller;
    }

    @Nullable
    public Standard parseStandard(String standardName) {
        switch (standardName) {
            case StandardUtils.DSTU_7_1_2006:
                    final URL path = getClass().getClassLoader().getResource(StandardUtils.DSTU_7_1_2006_PATH);
                    if (path == null) {
                        throw new IllegalArgumentException("Something is wrong with standard's file path");
                    }
                    final Serializer serializer = new Persister();
                    final File source = new File(path.getFile());
                    try {
                        return serializer.read(Standard.class, source);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                break;
            default:
                throw new IllegalArgumentException("There is no such standard");
        }
        return null;
    }

}
