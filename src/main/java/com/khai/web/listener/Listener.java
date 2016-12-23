package com.khai.web.listener;

import com.khai.db.model.CitationModel;
import com.khai.db.model.Person;
import com.khai.db.service.BibliographyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Listener for application context change.
 */
@Component
public class Listener implements ApplicationListener {

    @Autowired
    BibliographyService bibliographyService;

    /**
     * Initialise db on context init.
     *
     * @param event app event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
            initBibliographies();
        }
    }

    private Set<Person> getAuthorsForCitation1() {
        Set<Person> persons = new HashSet<>();

        Person person1 = new Person();
        person1.setName1("Н");
        person1.setName2("Т");
        person1.setSurname("Кунда");

        Person person2 = new Person();
        person2.setName1("О");
        person2.setName2("М");
        person2.setSurname("Куницька");

        persons.add(person1);
        persons.add(person2);

        return persons;
    }

    private Set<Person> getAuthorsForCitation2() {
        Set<Person> persons = new HashSet<>();

        Person person1 = new Person();
        person1.setName1("Н");
        person1.setName2("Н");
        person1.setSurname("Агафонова");

        Person person2 = new Person();
        person2.setName1("Т");
        person2.setName2("В");
        person2.setSurname("Богачева");

        Person person3 = new Person();

        person3.setName1("Л");
        person3.setName2("И");
        person3.setSurname("Глушкова");

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        return persons;
    }

    private Set<Person> getEditors() {
        Set<Person> persons = new HashSet<>();

        Person person1 = new Person();
        person1.setName1("А");
        person1.setName2("Г");
        person1.setSurname("Калпина");

        persons.add(person1);

        return persons;
    }

    private void initBibliographies() {
        CitationModel citation1 = new CitationModel();
        citation1.setTitle("Методи наукових досліджень");
        citation1.setAuthors(getAuthorsForCitation1());
        citation1.setPage("83");
        citation1.setYear("2007");
        citation1.setEditorType("Текст");
        citation1.setPublisher("НТУ");
        citation1.setType("Книги под именем автора (авторов)");

        CitationModel citation2 = new CitationModel();
        citation2.setTitle("Гражданское право");
        citation2.setAuthors(getAuthorsForCitation2());
        citation2.setPublisher("Юрист");
        citation2.setType("учеб. пособие для вузов");
        citation2.setEditors(getEditors());
        citation2.setEditorType("Текст");
        citation2.setPage("542");
        citation2.setYear("2002");

        bibliographyService.saveAll(Arrays.asList(citation1, citation2));
    }
}