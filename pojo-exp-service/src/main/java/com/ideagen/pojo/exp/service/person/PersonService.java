package com.ideagen.pojo.exp.service.person;

import com.ideagen.pojo.exp.entity.person.Person;
import com.ideagen.pojo.exp.model.dto.person.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto findPersonByName(String name);

    Person savePerson(PersonDto personDto);

    List<PersonDto> findAll();
}
