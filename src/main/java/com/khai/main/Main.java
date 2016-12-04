package com.khai.main;

import com.khai.xml.XmlController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String [ ] args) {
        try {
            new XmlController().test();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

}
