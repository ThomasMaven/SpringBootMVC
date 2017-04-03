package com.example;

import com.example.Service.PersonService;
import com.example.model.Contact;
import com.example.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by ttomaka on 28.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonIntegrationTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testFindAll() {
        List<Person> personList = personService.findAll();
        assertThat(personList.size(), is(greaterThanOrEqualTo(0)));
    }


    @Test
    public void testAddingPerson() {
        List<Person> personList = personService.findAll();
        int initialValues = personList.size();
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setName("Tester");
        personService.createPerson(tmp_person);
        personList = personService.findAll();

        assertThat(initialValues+1, is(personList.size()));
    }

    @Test
    public void testRemovingPerson() {
        List<Person> personList = personService.findAll();
        int initialValues = personList.size();
        Person personToDelete = personList.get(0);
        personService.deletePerson(personToDelete.getId());
        personList = personService.findAll();
        assertThat(initialValues-1, is(personList.size()));
    }

    @Test
    public void testUpdatingPerson() {
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setSurname("Tester");
        personService.createPerson(tmp_person);
        Person personToUpdate = personService.findOne(tmp_person.getId());
        String nameToUpdate = "SomeName123";
        personToUpdate.setName(nameToUpdate);
        String surnameToUpdate = "SomeSurnameName123";
        personToUpdate.setName(nameToUpdate);
        personToUpdate.setSurname(surnameToUpdate);
        personService.updatePerson(personToUpdate.getId(), personToUpdate);
        personToUpdate = personService.findOne(tmp_person.getId());
        assertThat(personToUpdate.getName(), is(equalTo(nameToUpdate)));
        assertEquals(personToUpdate.getSurname(), surnameToUpdate);
    }

    @Test
    public void testUpdatingPersonUsingService() {
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setSurname("Tester");
        personService.createPerson(tmp_person);
        Person personToUpdate = personService.findOne(tmp_person.getId());
        String nameToUpdate = "SomeName123";
        personService.setName(tmp_person.getId(), nameToUpdate);
        String surnameToUpdate = "SomeSurnameName123";
        personService.setSurname(tmp_person.getId(), surnameToUpdate);
        personToUpdate.setSurname(surnameToUpdate);
        personToUpdate = personService.findOne(tmp_person.getId());
        assertThat(personToUpdate.getName(), is(equalTo(nameToUpdate)));
        assertEquals(personToUpdate.getSurname(), surnameToUpdate);
    }

    @Test
    public void testContactList() {
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setSurname("Tester");
        personService.createPerson(tmp_person);
        List<Contact> contactList = new ArrayList<>();
        int numberOfContactsToAdd = 3;
        for(int i=0; i<numberOfContactsToAdd; i++) {
            Contact tmp_contatct = new Contact();
            tmp_contatct.setType("PHONE");
            tmp_contatct.setValue(String.valueOf(Math.random()));
            contactList.add(tmp_contatct);
        }
        tmp_person.setContacts(contactList);

        assertThat(tmp_person.getContacts(), equalTo(contactList));
        assertThat(tmp_person.getContacts().size(), equalTo(numberOfContactsToAdd));
    }

    @Test
    public void testContactListUsingService() {
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setSurname("Tester");
        tmp_person = personService.createPerson(tmp_person);
        int numberOfContactsToAdd = 3;
        for(int i=0; i<numberOfContactsToAdd; i++) {
            Contact tmp_contatct = new Contact();
            tmp_contatct.setType("PHONE");
            tmp_contatct.setValue(String.valueOf(Math.random()));
            tmp_person = personService.addContact(tmp_person.getId(), tmp_contatct);
        }
        assertThat(tmp_person.getContacts().size(), equalTo(numberOfContactsToAdd));
    }
    @Test
    public void testContactList2() {
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setSurname("Tester");
        personService.createPerson(tmp_person);
        List<Contact> contactList = new ArrayList<>();
        int numberOfContactsToAdd = 3;
        for(int i=0; i<numberOfContactsToAdd; i++) {
            Contact tmp_contatct = new Contact();
            tmp_contatct.setType("PHONE");
            tmp_contatct.setValue(String.valueOf(Math.random()));
            contactList.add(tmp_contatct);
        }
        tmp_person.setContacts(contactList);

        assertThat(tmp_person.getContacts(), equalTo(contactList));
        assertThat(tmp_person.getContacts().size(), equalTo(numberOfContactsToAdd));
    }
}
