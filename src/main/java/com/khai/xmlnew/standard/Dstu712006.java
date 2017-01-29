package com.khai.xmlnew.standard;

import com.khai.db.model.CitationModel;
import com.khai.xmlnew.standard.base.BaseStandard;
import com.khai.xmlnew.standard.base.Constants;
import com.khai.xmlnew.standard.model.Authors;
import com.khai.xmlnew.standard.model.CitationParts;
import com.khai.xmlnew.standard.model.Field;
import com.khai.xmlnew.standard.model.MultipartSeparator;
import org.dom4j.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dstu712006 extends BaseStandard {

    private CitationParts citationParts;

    public Dstu712006(String standardPath) {
        super(standardPath);
        citationParts = new CitationParts();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void fillCitationParts() {
        final List<Node> firstAuthorNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_FIRST_AUTHOR);
        final List<Node> titleNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_TITLE);
        final List<Node> editionTypeNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_EDITION_TYPE);
        final List<Node> typeNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_TYPE);
        final List<Node> additionalInfoNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_ADDITIONAL_INFO);
        final List<Node> editorsNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_EDITORS);
        final List<Node> authorsAfterNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_AUTHORS_AFTER);
        final List<Node> directorsNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_DIRECTORS);
        final List<Node> executorsNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_EXECUTORS);
        final List<Node> publisherCityNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_PUBLISHER_CITY);
        final List<Node> publisherNameNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_PUBLISHER_NAME);
        final List<Node> publisherNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_PUBLISHER);
        final List<Node> yearDateNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_YEAR_DATE);
        final List<Node> volumeNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_VOLUME);
        final List<Node> noNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_NO);
        final List<Node> pagesNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_PAGES);
        final List<Node> officialDateNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.CITATION_PARTS_OFFICIAL_DATE);
        citationParts.setFirstAuthors(getAuthors(firstAuthorNodes));
        citationParts.setTitles(getField(titleNodes));
        citationParts.setEditionTypes(getField(editionTypeNodes));
        citationParts.setTypes(getField(typeNodes));
        citationParts.setAdditionalInfos(getField(additionalInfoNodes));
        citationParts.setEditors(getAuthors(editorsNodes));
        citationParts.setAuthorsAfter(getAuthors(authorsAfterNodes));
        citationParts.setDirectors(getAuthors(directorsNodes));
        citationParts.setExecutors(getAuthors(executorsNodes));
        citationParts.setPublisherCities(getField(publisherCityNodes));
        citationParts.setPublisherNames(getField(publisherNameNodes));
        citationParts.setPublishers(getField(publisherNodes));
        citationParts.setYearDates(getField(yearDateNodes));
        citationParts.setVolume(getField(volumeNodes));
        citationParts.setNo(getField(noNodes));
        citationParts.setPages(getField(pagesNodes));
        citationParts.setOfficialDates(getField(officialDateNodes));
    }

    @Override
    public String getCitation(CitationModel citationModel) {
        final StringBuilder builder = new StringBuilder();
        //todo hardcode citation's type till type logic will be implemented
        builder.append(String.format(citationParts.getTitles()
                .get("default")
                .getFormattedValue(), citationModel.getTitle()));
        builder.append(String.format(citationParts.getTypes()
                .get("default")
                .getFormattedValue(), citationModel.getType()));
        builder.append(String.format(citationParts.getPublisherCities()
                .get("default")
                .getFormattedValue(), citationModel.getPublisher()));
        builder.append(String.format(citationParts.getPublisherNames()
                .get("default")
                .getFormattedValue(), citationModel.getPublisher()));
        builder.append(String.format(citationParts.getPublishers()
                .get("default")
                .getFormattedValue(), citationModel.getPublisher()));
        builder.append(String.format(citationParts.getVolume()
                .get("default")
                .getFormattedValue(), citationModel.getVolume()));
        builder.append(String.format(citationParts.getNo()
                .get("default")
                .getFormattedValue(), citationModel.getNo()));
        builder.append(String.format(citationParts.getPages()
                .get("default")
                .getFormattedValue(), citationModel.getPage()));
        return builder.toString();
    }

    private Map<String, Field> getField(List<Node> fieldsNodes) {
        final Map<String, Field> fields = new HashMap<>();
        final StringBuilder builder = new StringBuilder();
        String separatorBeforeName;
        String separatorAfterName;
        for (Node node : fieldsNodes) {
            final Field field = new Field();
            final String type = node.valueOf(Constants.XmlAttribute.TYPE);
            MultipartSeparator multipartSeparator;
            builder.setLength(0);
            separatorBeforeName = getMultipartSeparatorName(node, Constants.XmlNode.MULTIPART_SEPARATOR_BEFORE);
            separatorAfterName = getMultipartSeparatorName(node, Constants.XmlNode.MULTIPART_SEPARATOR_AFTER);
            field.setType(type);
            multipartSeparator = multipartSeparatorsBefore.get(separatorBeforeName);
            builder.append(multipartSeparator != null
                    ? multipartSeparator.getValue()
                    : "");
            builder.append("%s");
            multipartSeparator = multipartSeparatorsAfter.get(separatorAfterName);
            builder.append(multipartSeparator != null
                    ? multipartSeparator.getValue()
                    : "");
            field.setFormattedValue(builder.toString());
            fields.put(type, field);
        }
        return fields;
    }

    private Map<String, Authors> getAuthors(List<Node> authorsNodes) {
        //todo resolve issue with 'Authors' name -> review xml structure of authors (see TODO there)
        //todo implement multipart-separator-after after all authors
        final Map<String, Authors> authorsMap = new HashMap<>();
        String separatorSurname;
        String separatorName1;
        String separatorName2;
        for (Node node : authorsNodes) {
            final Authors authors = new Authors();
            final String condition = node.valueOf(Constants.XmlAttribute.CONDITION);
            final String type = node.valueOf(Constants.XmlAttribute.TYPE);
            MultipartSeparator multipartSeparator;
            separatorSurname = getMultipartSeparatorName(node.selectSingleNode(Constants.XmlNode.SURNAME),
                    Constants.XmlNode.MULTIPART_SEPARATOR_AFTER);
            separatorName1 = getMultipartSeparatorName(node.selectSingleNode(Constants.XmlNode.NAME1),
                    Constants.XmlNode.MULTIPART_SEPARATOR_AFTER);
            separatorName2 = getMultipartSeparatorName(node.selectSingleNode(Constants.XmlNode.NAME2),
                    Constants.XmlNode.MULTIPART_SEPARATOR_AFTER);
            authors.setType(type);
            authors.setCondition(condition);
            multipartSeparator = multipartSeparatorsAfter.get(separatorSurname);
            authors.setFormattedSurname(multipartSeparator != null
                    ? "%s" + multipartSeparator.getValue()
                    : "%s");
            multipartSeparator = multipartSeparatorsAfter.get(separatorName1);
            authors.setFormattedName1(multipartSeparator != null
                    ? "%s" + multipartSeparator.getValue()
                    : "%s");
            multipartSeparator = multipartSeparatorsAfter.get(separatorName2);
            authors.setFormattedName2(multipartSeparator != null
                    ? "%s" + multipartSeparator.getValue()
                    : "%s");

            authorsMap.put(condition + type, authors);
        }
        return authorsMap;
    }

    private String getMultipartSeparatorName(Node parentNode, String multipartSeparatorNodeName) {
        final String name;
        final String type;
        final Node multipartSeparatorNode = parentNode.selectSingleNode(multipartSeparatorNodeName);
        if (multipartSeparatorNode != null) {
            name = multipartSeparatorNode.valueOf(Constants.XmlAttribute.NAME);
            type = multipartSeparatorNode.valueOf(Constants.XmlAttribute.TYPE);
            return name + type;
        }
        return "";
    }

}
