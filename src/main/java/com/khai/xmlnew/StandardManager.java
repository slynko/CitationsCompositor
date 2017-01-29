package com.khai.xmlnew;

import com.khai.db.model.CitationModel;
import com.khai.xmlnew.standard.Dstu712006;
import com.khai.xmlnew.standard.base.Constants;
import com.khai.xmlnew.standard.base.StandardContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardManager {

    private static StandardManager standardManager;
    private Map<String, StandardContract> standards;

    public StandardManager() {
        standards = new HashMap<>();
    }

    public static StandardManager getInstance() {
        if (standardManager == null) {
            standardManager = new StandardManager();
        }
        return standardManager;
    }

    public List<String> makeCitations(String standardName, List<CitationModel> citations) {
        StandardContract standard;
        switch (standardName) {
            case Constants.StandardName.DSTU_7_1_2006:
                standard = retrieveStandard(Constants.StandardName.DSTU_7_1_2006,
                        Constants.StandardPath.DSTU_7_1_2006);
                break;
            default:
                throw new IllegalArgumentException("There is no implementation of the chosen standard");
        }
        return getCitations(standard, citations);
    }

    private StandardContract retrieveStandard(String name, String path) {
        final StandardContract standard;
        if (!standards.containsKey(name)) {
            standard = new Dstu712006(path);
            standard.make();
            standards.put(name, standard);
        } else {
            standard = standards.get(name);
        }
        return standard;
    }

    private List<String> getCitations(StandardContract standard, List<CitationModel> citations) {
        final List<String> resultCitations = new ArrayList<>();
        for (CitationModel citation: citations) {
            final String resultCitation = standard.getCitation(citation);
            resultCitations.add(resultCitation);
        }
        return resultCitations;
    }

}
