package com.khai.db.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "citation")
@Data
public class CitationModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "editor_type")
    private String editorType;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "authors")
    private Set<Person> authors;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "editors")
    private List<Person> editors;
    @Column(name = "publisher_name")
    private String publisherName;
    @Column(name = "publisher_city")
    private String publisherCity;
    @Column(name = "additional_info")
    private String additionalInfo;
    @Column(name = "editor_info")
    private String editorInfo;
    @Column(name = "year")
    private String year;
    @Column(name = "date")
    private String date;
    @Column(name = "volume")
    private String volume;
    @Column(name = "no")
    private String no;
    @Column(name = "page")
    private String page;

    @Override
    public String toString() {
        return title;
    }
}
