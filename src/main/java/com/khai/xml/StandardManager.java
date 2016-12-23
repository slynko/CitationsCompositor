package com.khai.xml;

import com.khai.db.model.CitationModel;
import com.khai.model.xml.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardManager {

    private static StandardManager manager;

    private Map<String, Standard> standardMap;

    private StandardManager() {
        standardMap = new HashMap<>();
    }

    public static synchronized StandardManager getInstance() {
        if (manager == null) {
            manager = new StandardManager();
        }
        return manager;
    }

    public List<String> makeBibliographies(String standardName, List<CitationModel> citations) {
        Standard chosenStandard = null;
        if (!standardMap.containsKey(standardName)) {
            chosenStandard = XmlParser.getInstance().parseStandard(standardName);
            standardMap.put(standardName, chosenStandard);
            makeStandard(chosenStandard);
        }
        return getBibliographies(chosenStandard, citations);
    }

    private void makeStandard(Standard standard) {
        final List<Separator> separators = standard.getSeparatorList();
        final List<MultipartSeparator> multipartSeparatorsAfter = standard.getMultiSeparatorsAfter();
        final List<MultipartSeparator> multipartSeparatorsBefore = standard.getMultiSeparatorsBefore();
        final CitationParts citationParts = standard.getCitationParts();
        fillMultipartSeparators(multipartSeparatorsAfter, separators);
        fillMultipartSeparators(multipartSeparatorsBefore, separators);
        fillPartsWithSeparators(citationParts, multipartSeparatorsBefore, multipartSeparatorsAfter);
    }

    private void fillMultipartSeparators(List<MultipartSeparator> multipartSeparators, List<Separator> separators) {
        for (MultipartSeparator multipartSeparator : multipartSeparators) {
            final List<Separator> separatorsInMultipart = multipartSeparator.getSeparators();
            int indexFoundSeparator;
            for (int i = 0; i < separatorsInMultipart.size(); i++) {
                indexFoundSeparator = separators.indexOf(separatorsInMultipart.get(i));
                if (indexFoundSeparator != -1) {
                    separatorsInMultipart.set(i, separators.get(indexFoundSeparator));
                }
            }
        }
    }

    private void fillPartsWithSeparators(CitationParts citationParts,
                                         List<MultipartSeparator> multipartSeparatorsBefore,
                                         List<MultipartSeparator> multipartSeparatorsAfter) {
        fillAuthors(citationParts.getFirstAuthors(), multipartSeparatorsAfter);
        fillFields(citationParts.getTitles(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getEditionTypes(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getTypes(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getAdditionalInfos(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillAuthors(citationParts.getEditors(), multipartSeparatorsAfter);
        fillAuthors(citationParts.getAuthorsAfter(), multipartSeparatorsAfter);
        fillAuthors(citationParts.getDirectors(), multipartSeparatorsAfter);
        fillAuthors(citationParts.getExecutors(), multipartSeparatorsAfter);
        fillFields(citationParts.getPublisherCities(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getPublisherNames(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getPublishers(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getYearDates(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getVolume(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getNo(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getPages(), multipartSeparatorsBefore, multipartSeparatorsAfter);
        fillFields(citationParts.getOfficialDates(), multipartSeparatorsBefore, multipartSeparatorsAfter);
    }

    private void fillAuthors(List<Authors> authorsList, List<MultipartSeparator> multipartSeparatorsAfter) {
        int indexFoundSeparator;
        for (Authors authors : authorsList) {
            for (Author author : authors.getAuthors()) {
                if (author.getName1().getSeparator() != null) {
                    indexFoundSeparator = multipartSeparatorsAfter.indexOf(author.getName1().getSeparator());
                    if (indexFoundSeparator != -1) {
                        author.getName1().setSeparator(multipartSeparatorsAfter.get(indexFoundSeparator));
                    }
                }
                if (author.getName2().getSeparator() != null) {
                    indexFoundSeparator = multipartSeparatorsAfter.indexOf(author.getName2().getSeparator());
                    if (indexFoundSeparator != -1) {
                        author.getName2().setSeparator(multipartSeparatorsAfter.get(indexFoundSeparator));
                    }
                }
                if (author.getSurname().getSeparator() != null) {
                    indexFoundSeparator = multipartSeparatorsAfter.indexOf(author.getSurname().getSeparator());
                    if (indexFoundSeparator != -1) {
                        author.getSurname().setSeparator(multipartSeparatorsAfter.get(indexFoundSeparator));
                    }
                }
            }
            //todo filling editor-type will be here
            indexFoundSeparator = multipartSeparatorsAfter.indexOf(authors.getMultipartSeparatorAfter());
            if (indexFoundSeparator != -1) {
                authors.setMultipartSeparatorAfter(multipartSeparatorsAfter.get(indexFoundSeparator));
            }
        }
    }

    private void fillFields(List<Field> fields, List<MultipartSeparator> multipartSeparatorsBefore,
                            List<MultipartSeparator> multipartSeparatorsAfter) {
        int indexFoundSeparator;
        for (Field field : fields) {
            if (field.getMultipartSeparatorBefore() != null) {
                indexFoundSeparator = multipartSeparatorsBefore.indexOf(field.getMultipartSeparatorBefore());
                if (indexFoundSeparator != -1) {
                    field.setMultipartSeparatorBefore(multipartSeparatorsBefore.get(indexFoundSeparator));
                }
            }
            if (field.getMultipartSeparatorAfter() != null) {
                indexFoundSeparator = multipartSeparatorsAfter.indexOf(field.getMultipartSeparatorAfter());
                if (indexFoundSeparator != -1) {
                    field.setMultipartSeparatorAfter(multipartSeparatorsAfter.get(indexFoundSeparator));
                }
            }
        }
    }

    private List<String> getBibliographies(Standard standard, List<CitationModel> citations) {
        List<String> bibliographies = new ArrayList<>();
        final String[] parts = standard.getCitations().get(0).getParts();
        for (CitationModel citation : citations) {
            final List<String> citationParts = getInfoForBibliography(parts, citation);
            final String bibliographiedString = makeBibliographiedString(standard, citationParts, "default", citation);
            bibliographies.add(bibliographiedString);
        }
        return bibliographies;
    }

    private List<String> getInfoForBibliography(String[] parts, CitationModel model) {
        final List<String> infoForBibliography = new ArrayList<>();
        for (String part : parts) {
            switch (Citations.fromString(part)) {
                case FIRST_AUTHOR:
                    //todo need to be implemented
                    break;
                case TITLE:
                    if (model.getTitle() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case EDITION_TYPE:
                    if (model.getEditorType() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case TYPE:
                    if (model.getType() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case ADDITIONAL_INFO:
                    //todo need to be implemented
                    break;
                case EDITORS:
                    if (model.getEditors() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case AUTHORS_AFTER:
                    //todo need to be implemented
                    break;
                case DIRECTORS:
                    //todo need to be implemented
                    break;
                case EXECUTORS:
                    //todo need to be implemented
                    break;
                case PUBLISHER_CITY:
                    if (model.getPublisherInfo() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case PUBLISHER_NAME:
                    if (model.getPublisherInfo() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case PUBLISHER:
                    if (model.getPublisher() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case YEAR_DATE:
                    if (model.getYear() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case VOLUME:
                    if (model.getVolume() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case NO:
                    if (model.getNo() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case PAGES:
                    if (model.getPage() != null) {
                        infoForBibliography.add(part);
                    }
                    break;
                case OFFICIAL_DATE:
                    //todo need to be implemented
                    break;
                default:
                    throw new IllegalArgumentException("There is no citation part like " + part);
            }
        }
        return infoForBibliography;
    }

    private String makeBibliographiedString(Standard standard, List<String> citationParts,
                                            String type, CitationModel model) {
        final StringBuilder builder = new StringBuilder();
        for (String citationPart : citationParts) {
            switch (Citations.fromString(citationPart)) {
                case FIRST_AUTHOR:
                    //todo need to be implemented
                    break;
                case TITLE:
                    addCitationPartFields(builder, standard.getCitationParts().getTitles(),
                            type, model.getTitle());
                    break;
                case EDITION_TYPE:
                    addCitationPartFields(builder, standard.getCitationParts().getEditionTypes(),
                            type, model.getEditorType());
                    break;
                case TYPE:
                    addCitationPartFields(builder, standard.getCitationParts().getTypes(),
                            type, model.getType());
                    break;
                case ADDITIONAL_INFO:
                    //todo need to be implemented
                    break;
                case EDITORS:
                    //todo need to be implemented
                    break;
                case AUTHORS_AFTER:
                    //todo need to be implemented
                    break;
                case DIRECTORS:
                    //todo need to be implemented
                    break;
                case EXECUTORS:
                    //todo need to be implemented
                    break;
                case PUBLISHER_CITY:
                    //todo will be divided
                    addCitationPartFields(builder, standard.getCitationParts().getPublisherCities(),
                            type, model.getPublisherInfo());
                    break;
                case PUBLISHER_NAME:
                    //todo will be divided
                    addCitationPartFields(builder, standard.getCitationParts().getPublisherNames(),
                            type, model.getPublisherInfo());
                    break;
                case PUBLISHER:
                    addCitationPartFields(builder, standard.getCitationParts().getPublishers(),
                            type, model.getPublisher());
                    break;
                case YEAR_DATE:
                    addCitationPartFields(builder, standard.getCitationParts().getYearDates(),
                            type, model.getYear());
                    break;
                case VOLUME:
                    addCitationPartFields(builder, standard.getCitationParts().getVolume(),
                            type, model.getVolume());
                    break;
                case NO:
                    addCitationPartFields(builder, standard.getCitationParts().getNo(),
                            type, model.getNo());
                    break;
                case PAGES:
                    addCitationPartFields(builder, standard.getCitationParts().getPages(),
                            type, model.getPage());
                    break;
                case OFFICIAL_DATE:
                    //todo need to be implemented
                    break;
                default:
                    throw new IllegalArgumentException("There is no citation part like ");
            }
        }
        return builder.toString();
    }

    private void addCitationPartFields(StringBuilder builder, List<Field> fields, String type, String info) {
        fields.stream()
                .filter(field -> field.getType().equals(type))
                .forEach(field -> {
                    if (field.getMultipartSeparatorBefore() != null) {
                        field.getMultipartSeparatorBefore()
                                .getSeparators()
                                .forEach(separator -> builder.append(separator.getSymbolDef()));
                    }
                    builder.append(info);
                    if (field.getMultipartSeparatorAfter() != null) {
                        field.getMultipartSeparatorAfter()
                                .getSeparators()
                                .forEach(separator -> builder.append(separator.getSymbolDef()));
                    }
                });
    }

    private void addCitationPartAuthors(StringBuilder builder, List<Authors> authorsList, String type, String info) {
        authorsList.stream()
                .filter(field -> field.getType().equals(type))
                .forEach(field -> {
                    builder.append(info);
                    if (field.getMultipartSeparatorAfter() != null) {
                        field.getMultipartSeparatorAfter()
                                .getSeparators()
                                .forEach(separator -> builder.append(separator.getSymbolDef()));
                    }
                });
    }


}
