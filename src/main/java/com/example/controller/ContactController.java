package com.example.controller;

import com.example.model.Contact;
import com.example.model.Person;
import com.example.repository.ContactRepository;
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
class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "contact", method = RequestMethod.GET)
    public List<Contact> contactList() {
        return contactRepository.findAll();
    }

    @RequestMapping(value = "contact/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable Long id) {
        return contactRepository.findOne(id);
    }

    @RequestMapping(value = "contact/{id}", method = RequestMethod.DELETE)
    public Contact deleteContact(@PathVariable Long id) {
        Contact contactToDel = contactRepository.findOne(id);
        contactRepository.delete(contactToDel);
        return contactToDel;
    }

    @RequestMapping(value = "contact/{id}/setType/{type}", method = RequestMethod.GET)
    public Contact setType(@PathVariable Long id, @PathVariable String type) {
        Contact contactToUpdate = contactRepository.findOne(id);
        contactToUpdate.setType(type);
        return contactRepository.saveAndFlush(contactToUpdate);
    }
    
    @RequestMapping(value = "contact/{id}/setValue/{value}", method = RequestMethod.GET)
    public Contact setValue(@PathVariable Long id, @PathVariable String value) {
        Contact contactToUpdate = contactRepository.findOne(id);
        contactToUpdate.setValue(value);
        return contactRepository.saveAndFlush(contactToUpdate);
    }

}
