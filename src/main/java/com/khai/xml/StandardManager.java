package com.khai.xml;

import com.khai.db.model.CitationModel;
import com.khai.xml.standard.Dstu712006;
import com.khai.xml.standard.base.Constants;
import com.khai.xml.standard.base.StandardContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that gives ability to make citations of desired standard
 */
public class StandardManager {

    private static StandardManager standardManager;
    private Map<String, StandardContract> standards;

    public StandardManager() {
        standards = new HashMap<>();
    }

    /**
     * Returns instance of {@link StandardManager} class
     *
     * @return new or already created instance of {@link StandardManager}
     */
    public static StandardManager getInstance() {
        if (standardManager == null) {
            standardManager = new StandardManager();
        }
        return standardManager;
    }

    /**
     * Provides built citations in string representation, from passed citation models,
     * with checking and instantiating of existed standards in application
     *
     * @param standardName name of standard, from which citations are needed
     * @param standardType type of citation from standard
     * @param citations    citation models, which are needed to be built
     * @return string representation of made citations
     */
    public List<String> makeCitations(String standardName,
                                      String standardType,
                                      List<CitationModel> citations) {
        StandardContract standard;
        switch (standardName) {
            case Constants.StandardName.DSTU_7_1_2006:
                standard = retrieveStandard(Constants.StandardName.DSTU_7_1_2006,
                        Constants.StandardPath.DSTU_7_1_2006);
                break;
            default:
                throw new IllegalArgumentException("There is no implementation of the chosen standard");
        }
        return getCitations(standard, standardType, citations);
    }

    /**
     * Retrieves types, which chosen standard provides
     *
     * @param standardName name of standard, from which types should be retrieved
     * @return Types with their internal key representation
     */
    public Map<String, String> getTypesOfStandard(String standardName) {
        StandardContract standard;
        switch (standardName) {
            case Constants.StandardName.DSTU_7_1_2006:
                standard = retrieveStandard(Constants.StandardName.DSTU_7_1_2006,
                        Constants.StandardPath.DSTU_7_1_2006);
                break;
            default:
                throw new IllegalArgumentException("There is no implementation of the chosen standard");
        }
        return standard.getTypes();
    }

    /**
     * Retrieves standard by path
     *
     * @param name name of standard
     * @param path path to standard in resources/standard/ directory
     * @return representation of concrete Standard
     */
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

    /**
     * Provides built citations in string representation, from passed citation models
     *
     * @param standard  concrete standard object
     * @param type      type of citation of standard
     * @param citations citation models, which are needed to be built
     * @return string representation of made citations
     */
    private List<String> getCitations(StandardContract standard,
                                      String type,
                                      List<CitationModel> citations) {
        final List<String> resultCitations = new ArrayList<>();
        for (CitationModel citation : citations) {
            final String resultCitation = standard.getCitation(citation, type);
            resultCitations.add(resultCitation);
        }
        return resultCitations;
    }

}
