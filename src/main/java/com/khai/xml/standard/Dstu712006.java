package com.khai.xml.standard;

import com.khai.db.model.CitationModel;
import com.khai.db.model.Person;
import com.khai.model.xml.Authors;
import com.khai.utils.TextUtils;
import com.khai.xml.standard.base.BaseStandard;

import java.util.Iterator;
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
    private void addCitationPart(String type, String citationPart,
                                 CitationModel model, StringBuilder builder) {
        //TODO Refactor this method :|
        Authors authors;
        String formattedValue;
        switch (citationPart) {
            case "first-author":
                //todo put logic of getting first author from code to xml
                if (model.getAuthors() == null || model.getAuthors().isEmpty()) return;
                if (model.getAuthors().size() > 4) return;
                final Person firstAuthor;
                authors = (Authors) citationParts.get(citationPart).get(type);
                if (authors == null) {
                    authors = (Authors) citationParts.get(citationPart).get("default");
                }
                firstAuthor = model.getAuthors().iterator().next();
                builder.append(String.format(authors.getFormattedSurname(), firstAuthor.getSurname()))
                        .append(String.format(authors.getFormattedName1(), firstAuthor.getName1()))
                        .append(String.format(authors.getFormattedName2(), firstAuthor.getName2()));
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
                //todo put logic of amount of authors and logic realted to getting first letter of name/second name to xml
                if (model.getAuthors() == null || model.getAuthors().isEmpty()) return;
                final String condition = model.getAuthors().size() <= 4 ? "lq4" : "gt4";
                final String authorsType = condition + type;
                authors = (Authors) citationParts.get(citationPart).get(authorsType);
                if (authors == null) {
                    authors = (Authors) citationParts.get(citationPart).get(condition + "default");
                }
                final Iterator<Person> authorsIterator = model.getAuthors().iterator();
                if (model.getAuthors().size() > 4) {
                    final Person person = authorsIterator.next();
                    builder.append(String.format(authors.getFormattedName1(), person.getName1()))
                            .append(String.format(authors.getFormattedName2(), person.getName2()))
                            .append(person.getSurname())
                            .append(authors.getFormattedAfter());
                } else {
                    do {
                        final Person person = authorsIterator.next();
                        builder.append(String.format(authors.getFormattedName1(), person.getName1()))
                                .append(String.format(authors.getFormattedName2(), person.getName2()))
                                .append(authorsIterator.hasNext()
                                        ? String.format(authors.getFormattedSurname(), person.getSurname())
                                        : person.getSurname());
                    } while (authorsIterator.hasNext());
                }
                break;
            case "publisher":
                if (TextUtils.isEmpty(model.getPublisher())) return;
                formattedValue = getFormattedFieldValue(citationPart, type);
                builder.append(String.format(formattedValue, model.getPublisher()));
                break;
            case "editors":
                //todo put logic of amount of authors and logic realted to getting first letter of name/second name to xml
                if (model.getEditors() == null || model.getEditors().isEmpty()) return;
                final String editorsCondition = model.getAuthors().size() <= 4 ? "lq4" : "gt4";
                final String editorsType = editorsCondition + type;
                authors = (Authors) citationParts.get(citationPart).get(editorsType);
                if (authors == null) {
                    authors = (Authors) citationParts.get(citationPart).get(editorsCondition + "default");
                }
                final Iterator<Person> editorsIterator = model.getEditors().iterator();
                builder.append(authors.getFormattedBefore());
                if (model.getEditors().size() > 4) {
                    final Person person = editorsIterator.next();
                    builder.append(String.format(authors.getFormattedName1(), person.getName1()))
                            .append(String.format(authors.getFormattedName2(), person.getName2()))
                            .append(person.getSurname())
                            .append(authors.getFormattedAfter());
                } else {
                    do {
                        final Person person = editorsIterator.next();
                        builder.append(String.format(authors.getFormattedName1(), person.getName1()))
                                .append(String.format(authors.getFormattedName2(), person.getName2()))
                                .append(editorsIterator.hasNext()
                                        ? String.format(authors.getFormattedSurname(), person.getSurname())
                                        : person.getSurname());
                    } while (editorsIterator.hasNext());
                }
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

}
