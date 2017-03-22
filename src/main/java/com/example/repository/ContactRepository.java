package com.example.repository;

import com.example.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ttomaka on 22.03.2017.
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
