package com.example;

import com.example.Service.PersonService;
import com.example.controller.PersonController;
import com.example.model.Person;
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
import static org.mockito.Mockito.*;

/**
 * Created by ttomaka on 28.03.2017.
 */
public class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPerson() {
        Person person = new Person();
        person.setId(1L);

        when(personService.findOne(1L)).thenReturn(person);

        Person per = personController.getPerson(1L);

        verify(personService).findOne(1L);
        //Make sure findAll method is not called.
        verify(personService, times(0)).findAll();

        assertThat(per, equalTo(person));
    }
    @Test
    public void testGetPerson2() {
        Person person = new Person();
        person.setId(1L);

        when(personService.findOne(1L)).thenReturn(person);

        Person per = personController.getPerson(1L);

        verify(personService).findOne(1L);

        assertEquals(per.getId(), person.getId());
    }

    @Test
    public void testGetPersonList() {
        List<Person> personList = new ArrayList<>();
        for(int i=0;i<3;i++) {
            Person tmp_person = new Person();
            tmp_person.setSurname("Surname"+i);
            tmp_person.setName("Name"+i);
            personList.add(tmp_person);
        }

        when(personService.findAll()).thenReturn(personList);

        List<Person> list = personController.personList();

        verify(personService).findAll();

        assertThat(list, equalTo(personList));
    }
}
