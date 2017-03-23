package com.example.controller;

import com.example.model.Contact;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ttomaka on 22.03.2017.
 */
@RestController
@RequestMapping("api/v1/")
class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "person", method = RequestMethod.GET)
    public List<Person> personList() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {

        return personRepository.saveAndFlush(person);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.PUT)
    public Person updateContact(@PathVariable Long id, @RequestBody Person person) {
        Person existingPerson = personRepository.findOne(id);
        BeanUtils.copyProperties(person, existingPerson);
        return personRepository.saveAndFlush(existingPerson);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
    public Person deletePerson(@PathVariable Long id) {
        Person personToDelete = personRepository.findOne(id);
        personRepository.delete(personToDelete);
        return personToDelete;
    }

    @RequestMapping(value = "person/{id}/addContact", method = RequestMethod.POST)
    public Person addContact(@PathVariable Long id, @RequestBody Contact contact) {
        Person personToUpdate = personRepository.findOne(id);
        personToUpdate.getContacts().add(contact);
        return personRepository.saveAndFlush(personToUpdate);
    }

    @RequestMapping(value = "person/{id}/setName/{name}", method = RequestMethod.GET)
    public Person setName(@PathVariable Long id, @PathVariable String name) {
        Person personToUpdate = personRepository.findOne(id);
        personToUpdate.setName(name);
        return personRepository.saveAndFlush(personToUpdate);
    }

    @RequestMapping(value = "person/{id}/setSurname/{surname}", method = RequestMethod.GET)
    public Person setSurname(@PathVariable Long id, @PathVariable String surname) {
        Person personToUpdate = personRepository.findOne(id);
        personToUpdate.setSurname(surname);
        return personRepository.saveAndFlush(personToUpdate);
    }
}
