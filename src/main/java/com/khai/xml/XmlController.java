package com.khai.xml;

import com.khai.db.model.CitationModel;
import com.khai.model.MultipartSeparator;
import com.khai.model.proposed.CitationParts;
import com.khai.model.proposed.Standard;
import com.khai.utils.StandardUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for making bibliographies
 */
public class XmlController {

    private static XmlController controller;
    private Standard standard;

    private XmlController() {
    }

    public static synchronized XmlController getInstance() {
        if (controller == null) {
            controller = new XmlController();
        }
        return controller;
    }

    public List<String> makeBibliographies(String standardName, List<CitationModel> citations) {
        chooseStandard(standardName);
        return getBibliographies(citations);
    }

    private void chooseStandard(String standardName) {
        switch (standardName) {
            case StandardUtils.DSTU_7_1_2006:
                final URL path = getClass().getClassLoader().getResource(StandardUtils.DSTU_7_1_2006_PATH);
                if (path == null) {
                    throw new IllegalArgumentException("Something is wrong with standard's file path");
                }
                final Serializer serializer = new Persister();
                final File source = new File(path.getFile());
                try {
                    standard = serializer.read(Standard.class, source);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("There is no such standard") ;
        }
    }

    private List<String> getBibliographies(List<CitationModel> citations) {
        List<String> bibliographies = new ArrayList<>();
        final CitationParts citationParts = standard.getCitationParts();
        final List<MultipartSeparator> multipartSeparatorsAfter = standard.getMultiSeparatorsAfter();
        final List<MultipartSeparator> multipartSeparatorsBefore = standard.getMultiSeparatorsBefore();
        final String[] parts = standard.getCitations().get(0).getParts();
        //TODO logic of making bibliographies will be implemented here
        return bibliographies;
    }

}
