package com.example.controller;

import com.example.Service.ContactService;
import com.example.model.Contact;
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
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("contact")
    public List<Contact> contactList() {
        return contactService.findAll();
    }

    @GetMapping("contact/{id}")
    public Contact getContact(@PathVariable Long id) {
        return contactService.findOne(id);
    }

    @DeleteMapping("contact/{id}")
    public Contact deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }

    @GetMapping("contact/{id}/setType/{type}")
    public Contact setType(@PathVariable Long id, @PathVariable String type) {
         return contactService.setType(id, type);
    }

    @GetMapping("contact/{id}/setValue/{value}")
    public Contact setValue(@PathVariable Long id, @PathVariable String value) {
        return contactService.setType(id, value);
    }

    @PutMapping("contact/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }
}
