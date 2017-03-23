package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ttomaka on 22.03.2017.
 */
@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Contact> contacts = new ArrayList<>();


//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<Contact> contacts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact c) {
        this.contacts.add(c);
        c.setPerson(this);

    }

    @PrePersist
    public void setUpReferences() {
        contacts.stream().forEach(c  -> c.setPerson(this));
    }

}
