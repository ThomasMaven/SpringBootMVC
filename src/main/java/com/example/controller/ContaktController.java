package com.example.controller;

import com.example.model.Contact;
import com.example.model.Person;
import com.example.repository.ContactRepository;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ttomaka on 22.03.2017.
 */
@RestController
@RequestMapping("api/v1/")
public class ContaktController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "personList", method = RequestMethod.GET)
    public List<Person> personList() {
        return personRepository.findAll();
    }

}
