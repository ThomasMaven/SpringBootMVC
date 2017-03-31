package com.example;

import com.example.model.Contact;
import com.example.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by ttomaka on 31.03.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ContactIntegrationTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testFindAll() {
        List<Contact> contactList = contactRepository.findAll();
        assertThat(contactList.size(), is(greaterThanOrEqualTo(0)));
    }


    @Test
    public void testRemovingContact() {
        List<Contact> contactList = contactRepository.findAll();
        int initialValues = contactList.size();
        Contact contactToDelete = contactList.get(0);
        contactRepository.delete(contactToDelete);
        contactList = contactRepository.findAll();
        contactList = contactRepository.findAll();
        assertThat(initialValues-1, is(contactList.size()));
    }

    @Test
    public void testUpdatingContactType() {
        List<Contact> contactList = contactRepository.findAll();
        Contact testContact = contactList.get(0);
        String typeToUpadate = "SomeType";
        testContact.setType(typeToUpadate);
        contactRepository.saveAndFlush(testContact);
        testContact = contactRepository.findOne(testContact.getId());
        assertThat(testContact.getType(), is(equalTo(typeToUpadate)));
    }

    @Test
    public void testUpdatingContactValue() {
        List<Contact> contactList = contactRepository.findAll();
        Contact testContact = contactList.get(0);
        String valueToUpadate = "SomeValue";
        testContact.setType(valueToUpadate);
        contactRepository.saveAndFlush(testContact);
        testContact = contactRepository.findOne(testContact.getId());
        assertThat(testContact.getType(), is(equalTo(valueToUpadate)));
    }


}
