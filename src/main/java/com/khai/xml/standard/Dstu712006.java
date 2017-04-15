package com.khai.xml.standard;

import com.khai.db.model.CitationModel;
import com.khai.db.model.Person;
import com.khai.model.xml.AuthorsWrapper;
import com.khai.utils.TextUtils;
import com.khai.xml.standard.base.BaseStandard;
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
        String formattedValue;
        switch (citationPart) {
            case "first-author":
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
            case "title":
                if (TextUtils.isEmpty(model.getTitle())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getTitle()));
                break;
            case "type":
                if (TextUtils.isEmpty(model.getType())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getType()));
                break;
            case "edition-type":
                if (TextUtils.isEmpty(model.getEditorType())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getEditorType()));
                break;
            case "authors-after":
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
            case "publisher":
                if (TextUtils.isEmpty(model.getPublisher())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getPublisher()));
                break;
            case "editors":
                // TODO: 4/15/2017 do editors like authors-after (do xml too)
                break;
            case "directors":
                // TODO: 4/15/2017 do editors like authors-after (do xml too)
                break;
            case "publisher-city":
                if (TextUtils.isEmpty(model.getPublisherInfo())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getPublisherInfo()));
                break;
            case "publisher-name":
                if (TextUtils.isEmpty(model.getPublisherInfo())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getPublisherInfo()));
                break;
            case "year-date":
                if (TextUtils.isEmpty(model.getYear())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getYear()));
                break;
            case "volume":
                if (TextUtils.isEmpty(model.getVolume())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getVolume()));
                break;
            case "no":
                if (TextUtils.isEmpty(model.getNo())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getNo()));
                break;
            case "pages":
                if (TextUtils.isEmpty(model.getPage())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getPage()));
                break;
        }
    }

    @Nullable
    @SuppressWarnings("unchecked")
    private AuthorsWrapper chooseAuthorsWrapper(String type, String citationPart, int sizeOfAuthors) {
        List<AuthorsWrapper> authorsWrappers = (List<AuthorsWrapper>) citationParts.get(citationPart).get(type);
        if (authorsWrappers == null) {
            authorsWrappers = (List<AuthorsWrapper>) citationParts.get(citationPart).get("default");
        }
        AuthorsWrapper chosenAuthorsWrapper = null;
        for (AuthorsWrapper authorsWrapper : authorsWrappers) {
            if (authorsWrapper.getCondition().equals("lq") && sizeOfAuthors <= authorsWrapper.getCount()) {
                chosenAuthorsWrapper = authorsWrapper;
                break;
            } else if (authorsWrapper.getCondition().equals("gt") && sizeOfAuthors > authorsWrapper.getCount()) {
                chosenAuthorsWrapper = authorsWrapper;
                break;
            } else if (authorsWrapper.getCondition().equals("lt") && sizeOfAuthors < authorsWrapper.getCount()) {
                chosenAuthorsWrapper = authorsWrapper;
                break;
            } else if (authorsWrapper.getCondition().equals("gq") && sizeOfAuthors >= authorsWrapper.getCount()) {
                chosenAuthorsWrapper = authorsWrapper;
                break;
            }
        }
        return chosenAuthorsWrapper;
    }

}
