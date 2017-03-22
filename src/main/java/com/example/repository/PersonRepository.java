package com.example.repository;

import com.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ttomaka on 22.03.2017.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
