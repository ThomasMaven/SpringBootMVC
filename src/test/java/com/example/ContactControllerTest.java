package com.example;

import com.example.Service.ContactService;
import com.example.controller.ContactController;
import com.example.model.Contact;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ttomaka on 31.03.2017.
 */
public class ContactControllerTest {

    @InjectMocks
    private ContactController contactController;

    @Mock
    private ContactService contactService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetContact() {
        Contact contact = new Contact();
        contact.setId(1L);

        when(contactService.findOne(1L)).thenReturn(contact);

        Contact per = contactController.getContact(1L);

        verify(contactService).findOne(1L);

        assertThat(per, equalTo(contact));
    }
    @Test
    public void testGetContact2() {
        Contact contact = new Contact();
        contact.setId(1L);

        when(contactService.findOne(1L)).thenReturn(contact);

        Contact per = contactController.getContact(1L);

        verify(contactService).findOne(1L);

        assertEquals(per.getId(), contact.getId());
    }

    @Test
    public void testGetContactList() {
        List<Contact> contactList = new ArrayList<>();
        for(int i=0;i<3;i++) {
            Contact tmp_contact = new Contact();
            tmp_contact.setType("Type"+i);
            tmp_contact.setValue("Value"+i);
            contactList.add(tmp_contact);
        }

        when(contactService.findAll()).thenReturn(contactList);

        List<Contact> list = contactController.contactList();

        assertThat(list, equalTo(contactList));
    }
}
