package com.example.Service;

import com.example.model.Contact;
import com.example.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ttomaka on 29.03.2017.
 */
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Transactional
    public Contact findOne(Long id) {
        return contactRepository.findOne(id);
    }

    @Transactional
    public Contact deleteContact(Long id) {
        Contact contactToDel = contactRepository.findOne(id);
        contactRepository.delete(contactToDel);
        return contactToDel;
    }

    @Transactional
    public Contact setType(Long id, String type) {
        Contact contactToUpdate = contactRepository.findOne(id);
        contactToUpdate.setType(type);
        return contactRepository.saveAndFlush(contactToUpdate);
    }

    @Transactional
    public Contact setValue(Long id, String value) {
        Contact contactToUpdate = contactRepository.findOne(id);
        contactToUpdate.setValue(value);
        return contactRepository.saveAndFlush(contactToUpdate);
    }

    @Transactional
    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = contactRepository.findOne(id);
        BeanUtils.copyProperties(contact, existingContact);
        return contactRepository.saveAndFlush(existingContact);
    }
}
