package com.example;

import com.example.Service.ContactService;
import com.example.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
public class ContactIntegrationTest {


    @Autowired
    private ContactService contactService;

    @Test
    public void testFindAll() {
        List<Contact> contactList = contactService.findAll();
        assertThat(contactList.size(), is(greaterThanOrEqualTo(0)));
    }


    @Test
    public void testRemovingContact() {
        List<Contact> contactList = contactService.findAll();
        int initialValues = contactList.size();
        Contact contactToDelete = contactList.get(0);
        contactService.deleteContact(contactToDelete.getId());
        contactList = contactService.findAll();
        assertThat(initialValues-1, is(contactList.size()));
    }

    @Test
    public void testUpdatingContactType() {
        List<Contact> contactList = contactService.findAll();
        Contact testContact = contactList.get(0);
        String typeToUpadate = "SomeType";
        testContact.setType(typeToUpadate);
        contactService.updateContact(testContact.getId(), testContact);
        testContact = contactService.findOne(testContact.getId());
        assertThat(testContact.getType(), is(equalTo(typeToUpadate)));
    }
    @Test
    public void testUpdatingContactTypeUsingService() {
        List<Contact> contactList = contactService.findAll();
        Contact testContact = contactList.get(0);
        String typeToUpadate = "SomeType";
        contactService.setType(testContact.getId(), typeToUpadate);
        testContact = contactService.findOne(testContact.getId());
        assertThat(testContact.getType(), is(equalTo(typeToUpadate)));
    }

    @Test
    public void testUpdatingContactValue() {
        List<Contact> contactList = contactService.findAll();
        Contact testContact = contactList.get(0);
        String valueToUpadate = "SomeValue";
        testContact.setValue(valueToUpadate);
        contactService.updateContact(testContact.getId(), testContact);
        testContact = contactService.findOne(testContact.getId());
        assertThat(testContact.getValue(), is(equalTo(valueToUpadate)));
    }
    @Test
    public void testUpdatingContactValueUsingService() {
        List<Contact> contactList = contactService.findAll();
        Contact testContact = contactList.get(0);
        String valueToUpadate = "SomeValue";
        contactService.setValue(testContact.getId(), valueToUpadate);
        testContact = contactService.findOne(testContact.getId());
        assertThat(testContact.getValue(), is(equalTo(valueToUpadate)));
    }


}
