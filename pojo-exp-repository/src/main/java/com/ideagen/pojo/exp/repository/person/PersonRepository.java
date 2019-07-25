package com.ideagen.pojo.exp.repository.person;

import com.ideagen.pojo.exp.entity.person.Person;

import java.util.List;

public interface PersonRepository {

    Person findById(long id);

    Person findByName(String name);

    Person save(Person person);

    List<Person> getAll();
}
