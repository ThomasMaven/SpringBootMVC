package com.example.controller;

import com.example.Service.PersonService;
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
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("person")
    public List<Person> personList() {
        return personService.findAll();
    }

    @RequestMapping(value = "person", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return personService.findOne(id);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.DELETE)
    public Person deletePerson(@PathVariable Long id) {
        return personService.deletePerson(id);
    }

    @RequestMapping(value = "person/{id}/addContact", method = RequestMethod.POST)
    public Person addContact(@PathVariable Long id, @RequestBody Contact contact) {
        return personService.addContact(id, contact);
    }

    @RequestMapping(value = "person/{id}/setName/{name}", method = RequestMethod.GET)
    public Person setName(@PathVariable Long id, @PathVariable String name) {
        return personService.setName(id, name);
    }

    @RequestMapping(value = "person/{id}/setSurname/{surname}", method = RequestMethod.GET)
    public Person setSurname(@PathVariable Long id, @PathVariable String surname) {
        return personService.setSurname(id, surname);
    }
}
