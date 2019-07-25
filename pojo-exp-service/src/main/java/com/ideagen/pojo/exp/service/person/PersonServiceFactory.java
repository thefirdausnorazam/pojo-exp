package com.ideagen.pojo.exp.service.person;

import com.ideagen.pojo.exp.repository.person.PersonRepository;

public class PersonServiceFactory {

    public static PersonService getService(PersonRepository personRepository) {
        return new PersonServiceImpl(personRepository);
    }
}
