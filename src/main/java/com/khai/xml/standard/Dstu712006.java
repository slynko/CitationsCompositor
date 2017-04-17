package com.khai.xml.standard;

import com.khai.db.model.CitationModel;
import com.khai.db.model.Person;
import com.khai.model.xml.AuthorsWrapper;
import com.khai.utils.TextUtils;
import com.khai.xml.standard.base.BaseStandard;
import com.khai.xml.standard.base.Constants;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Dstu712006 extends BaseStandard {

    public Dstu712006(String standardPath) {
        super(standardPath);
    }

    @Override
    public String getCitation(CitationModel citationModel, String type) {
        final List<String> parts = citations.get(type);
        if (parts == null) return "Type that you chose is not supported";
        final StringBuilder builder = new StringBuilder();
        for (String part : parts) {
            addCitationPart(type, part, citationModel, builder);
        }
        return builder.toString();
    }

    /**
     * Adds citation part to result citation string representation
     *
     * @param type         type of citation
     * @param citationPart citation part which is needed to be added
     * @param model        citation model, from which data for citation part is retrieved
     * @param builder      result citation string representation
     */
    @SuppressWarnings("unchecked")
    private void addCitationPart(String type, String citationPart,
                                 CitationModel model, StringBuilder builder) {
        switch (citationPart) {
            case Constants.Tags.FIRST_AUTHOR:
                if (model.getAuthors() == null || model.getAuthors().isEmpty()) return;
                final AuthorsWrapper chosenFirstAuthorWrapper = chooseAuthorsWrapper(type, citationPart,
                        model.getAuthors().size());
                if (chosenFirstAuthorWrapper == null) return;
                int firstAuthorsWrapperSize = chosenFirstAuthorWrapper.getAuthors().size();
                final List<Person> firstAuthorsInModel = new ArrayList<>(model.getAuthors());
                for (int i = 0; i < firstAuthorsWrapperSize; i++) {
                    final Person firstAuthor;
                    if (i == firstAuthorsInModel.size() - 1) {
                        firstAuthor = firstAuthorsInModel.get(i);
                        builder.append(String.format(chosenFirstAuthorWrapper.getAuthors().get(firstAuthorsWrapperSize - 1).getFormattedValue(),
                                firstAuthor.getSurname(), firstAuthor.getName1(), firstAuthor.getName2()));
                    } else {
                        firstAuthor = firstAuthorsInModel.get(i);
                        builder.append(String.format(chosenFirstAuthorWrapper.getAuthors().get(i).getFormattedValue(),
                                firstAuthor.getSurname(), firstAuthor.getName1(), firstAuthor.getName2()));
                    }
                }
                break;
            case Constants.Tags.AUTHORS_AFTER:
                if (model.getAuthors() == null || model.getAuthors().isEmpty()) return;
                final AuthorsWrapper chosenAuthorsAfterWrapper = chooseAuthorsWrapper(type, citationPart,
                        model.getAuthors().size());
                if (chosenAuthorsAfterWrapper == null) return;
                final List<Person> authorsAfterInModel = new ArrayList<>(model.getAuthors());
                int authorsAfterWrapperSize = chosenAuthorsAfterWrapper.getAuthors().size();
                builder.append(chosenAuthorsAfterWrapper.getFormattedBefore());
                for (int i = 0; i < authorsAfterWrapperSize; i++) {
                    final Person firstAuthor;
                    if (i == authorsAfterInModel.size() - 1) {
                        firstAuthor = authorsAfterInModel.get(i);
                        builder.append(String.format(chosenAuthorsAfterWrapper.getAuthors().get(authorsAfterWrapperSize - 1).getFormattedValue(),
                                firstAuthor.getName1(), firstAuthor.getName2(), firstAuthor.getSurname()));
                        break;
                    } else {
                        firstAuthor = authorsAfterInModel.get(i);
                        builder.append(String.format(chosenAuthorsAfterWrapper.getAuthors().get(i).getFormattedValue(),
                                firstAuthor.getName1(), firstAuthor.getName2(), firstAuthor.getSurname()));
                    }
                }
                builder.append(chosenAuthorsAfterWrapper.getFormattedAfter());
                break;

            case Constants.Tags.EDITORS:
                // TODO: 4/15/2017 do editors like authors-after (do xml too)
                break;
            case Constants.Tags.DIRECTORS:
                // TODO: 4/15/2017 do editors like authors-after (do xml too)
                break;
            default:
                parseField(getValueFromModel(citationPart, model), citationPart, builder, type);
        }
    }

    private String getValueFromModel(String citationPart, CitationModel model) throws IllegalArgumentException {
        switch (citationPart) {
            case Constants.Tags.PUBLISHER:
                return model.getPublisher();
            case Constants.Tags.TITLE:
                return model.getTitle();
            case Constants.Tags.TYPE:
                return model.getType();
            case Constants.Tags.EDITION_TYPE:
                return model.getEditorType();
            case Constants.Tags.PUBLISHER_CITY:
                return model.getPublisherCity();
            case Constants.Tags.PUBLISHER_NAME:
                return model.getPublisherName();
            case Constants.Tags.YEAR_DATE:
                return model.getYear();
            case Constants.Tags.VOLUME:
                return model.getVolume();
            case Constants.Tags.NO:
                return model.getNo();
            case Constants.Tags.PAGES:
                return model.getPage();
            default:
                throw new IllegalArgumentException("Illegal citation part " + citationPart);
        }
    }

    private void parseField(String value, String citationPart, StringBuilder builder, String type) {
        if (TextUtils.isEmpty(value)) return;
        String formattedValue = getFormattedFieldValue(citationPart, type);
        builder.append(String.format(formattedValue, value));
    }

    @Nullable
    @SuppressWarnings("unchecked")
    private AuthorsWrapper chooseAuthorsWrapper(String type, String citationPart, int sizeOfAuthors) {
        List<AuthorsWrapper> authorsWrappers = (List<AuthorsWrapper>) citationParts.get(citationPart).get(type);
        if (authorsWrappers == null) {
            authorsWrappers = (List<AuthorsWrapper>) citationParts.get(citationPart).get("default");
        }
        int authorsWrapperCount;
        for (AuthorsWrapper authorsWrapper : authorsWrappers) {
            authorsWrapperCount = authorsWrapper.getCount();
            switch (authorsWrapper.getCondition()) {
                case Constants.Conditions.LESS_OR_EQUAL:
                    if (sizeOfAuthors <= authorsWrapperCount)
                        return authorsWrapper;
                case Constants.Conditions.GREATER_THAN:
                    if (sizeOfAuthors > authorsWrapperCount)
                        return authorsWrapper;
                case Constants.Conditions.LESS_THAN:
                    if (sizeOfAuthors < authorsWrapperCount)
                        return authorsWrapper;
                case Constants.Conditions.GREATER_OR_EQUAL:
                    if (sizeOfAuthors >= authorsWrapperCount)
                        return authorsWrapper;
            }
        }
        return null;
    }

}
