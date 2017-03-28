package com.example;

import com.example.model.Contact;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ttomaka on 23.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PersonPersistenceTest {

    @Autowired
    private
    PersonRepository personRepository;

    @Test
    public void testPersistence() {
        Person p = new Person();
        p.setName("Test");
        p.setSurname("Test");


        Contact c = new Contact();
        c.setValue("A");
        c.setType("B");
        //p.addContact(c);

        personRepository.saveAndFlush(p);


    }

}
