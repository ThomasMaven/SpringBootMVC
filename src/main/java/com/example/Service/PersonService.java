package com.example.Service;

import com.example.model.Contact;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ttomaka on 29.03.2017.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public Person findOne(Long id) {
        return personRepository.findOne(id);
    }

    @Transactional
    public Person createPerson(Person person) {
        return personRepository.saveAndFlush(person);
    }

    @Transactional
    public Person updatePerson(Long id, Person person) {
        Person existingPerson = personRepository.findOne(id);
        BeanUtils.copyProperties(person, existingPerson);
        return personRepository.saveAndFlush(existingPerson);
    }

    @Transactional
    public Person deletePerson(Long id) {
        Person personToDelete = personRepository.findOne(id);
        personRepository.delete(personToDelete);
        return personToDelete;
    }

    @Transactional
    public Person addContact(Long id, Contact contact) {
        Person personToUpdate = personRepository.findOne(id);
        personToUpdate.getContacts().add(contact);
        return personRepository.saveAndFlush(personToUpdate);
    }

    @Transactional
    public Person setName(Long id, String name) {
        Person personToUpdate = personRepository.findOne(id);
        personToUpdate.setName(name);
        return personRepository.saveAndFlush(personToUpdate);
    }

    @Transactional
    public Person setSurname(Long id, String surname) {
        Person personToUpdate = personRepository.findOne(id);
        personToUpdate.setSurname(surname);
        return personRepository.saveAndFlush(personToUpdate);
    }
}
