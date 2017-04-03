package com.example;

import com.example.Service.ContactService;
import com.example.controller.ContactController;
import com.example.model.Contact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by ttomaka on 31.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private ContactController contactController;

    @Mock
    private ContactService contactService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
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
    public void testGetContactListMVC() throws Exception {
        List<Contact> contactList = new ArrayList<>();
        for(int i=0;i<3;i++) {
            Contact tmp_contact = new Contact();
            tmp_contact.setType("Type"+i);
            tmp_contact.setValue("Value"+i);
            contactList.add(tmp_contact);
        }
        when(contactService.findAll()).thenReturn(contactList);
        mockMvc.perform(get("/api/v1/contact")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].value", is("Value0")))
                .andExpect(jsonPath("$[0].type", is("Type0")));
        verify(contactService).findAll();
        verifyNoMoreInteractions(contactService);
    }

    @Test
    public void testGetContactMVC() throws Exception {
        Contact contact = new Contact();
        contact.setId(1L);
        when(contactService.findOne(1L)).thenReturn(contact);

        mockMvc.perform(get("/api/v1/contact/"+contact.getId(), 1)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)));
        verify(contactService).findOne(contact.getId());
        verifyNoMoreInteractions(contactService);
    }
    @Test
    public void testDeleteContactMVC() throws Exception {
        Contact contact = new Contact();
        contact.setId(1L);
        mockMvc.perform(delete("/api/v1/contact/"+contact.getId())).andExpect(status().isOk());
        verify(contactService).deleteContact(contact.getId());
        verifyNoMoreInteractions(contactService);
    }



}
