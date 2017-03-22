package com.example.controller;

import com.example.model.Contact;
import com.example.repository.ContactRepository;
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
public class UserController {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "contactList", method = RequestMethod.GET)
    public List<Contact> contactList() {
        return contactRepository.findAll();
    }
}
