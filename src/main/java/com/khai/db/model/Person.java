package com.khai.db.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name1")
    private String name1;
    @Column(name = "name2")
    private String name2;
    @Column(name = "surname")
    private String surname;
}
