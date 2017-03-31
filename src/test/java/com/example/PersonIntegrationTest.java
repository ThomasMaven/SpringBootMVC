package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import com.example.Service.PersonService;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ttomaka on 28.03.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class PersonIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testFindAll() {
        List<Person> personList = personRepository.findAll();
        assertThat(personList.size(), is(greaterThanOrEqualTo(0)));
    }

    @Test
    public void testAddingPerson() {
        List<Person> personList = personRepository.findAll();
        int initialValues = personList.size();
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setName("Tester");
        personRepository.saveAndFlush(tmp_person);
        personList = personRepository.findAll();

        assertThat(initialValues+1, is(personList.size()));
    }

    @Test
    public void testRemovingPerson() {
        List<Person> personList = personRepository.findAll();
        int initialValues = personList.size();
        Person personToDelete = personList.get(0);
        personRepository.delete(personToDelete);
        personList = personRepository.findAll();
        personList = personRepository.findAll();
        assertThat(initialValues-1, is(personList.size()));
    }

    @Test
    public void testUpdatingPerson() {
        Person tmp_person = new Person();
        tmp_person.setName("Integration");
        tmp_person.setName("Tester");
        personRepository.saveAndFlush(tmp_person);
        Person personToUpdate = personRepository.findOne(tmp_person.getId());
        String nameToUpdate = "SomeName123";
        personToUpdate.setName(nameToUpdate);
        personRepository.saveAndFlush(personToUpdate);
        personToUpdate = personRepository.findOne(tmp_person.getId());
        assertThat(personToUpdate.getName(), is(equalTo(nameToUpdate)));
    }
}
