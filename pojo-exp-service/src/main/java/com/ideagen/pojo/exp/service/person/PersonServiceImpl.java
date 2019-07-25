package com.ideagen.pojo.exp.service.person;

import com.ideagen.pojo.exp.entity.person.Address;
import com.ideagen.pojo.exp.entity.person.Person;
import com.ideagen.pojo.exp.model.dto.person.PersonDto;
import com.ideagen.pojo.exp.repository.person.PersonRepository;
import com.ideagen.pojo.exp.service.person.PersonService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Business logic here
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    public PersonDto findPersonByName(String name) {
        Person person = personRepository.findByName(name);

        if (person != null) {
            return new PersonDto(person.getName(),
                    person.getFullName(),
                    person.getAge(),
                    person.getAddress().getAddressLine1(),
                    person.getAddress().getAddressLine2(),
                    person.getAddress().getPostCode(),
                    person.getAddress().getCity(),
                    person.getAddress().getState(),
                    person.getAddress().getCountry());
        } else {
            return null;
        }
    }

    public Person savePerson(PersonDto personDto) {
        Address address = new Address(personDto.getAddressLine1(),
                personDto.getAddressLine2(),
                personDto.getPostCode(),
                personDto.getCity(),
                personDto.getState(),
                personDto.getCountry());

        Person person = new Person();
        person.setName(personDto.getName());
        person.setFullName(personDto.getFullName());
        person.setAge(personDto.getAge());
        person.setAddress(address);

        return personRepository.save(person);
    }

    public List<PersonDto> findAll() {
        return personRepository.getAll()
                .stream()
                .map(person -> new PersonDto(person.getName(),
                        person.getFullName(),
                        person.getAge(),
                        person.getAddress().getAddressLine1(),
                        person.getAddress().getAddressLine2(),
                        person.getAddress().getPostCode(),
                        person.getAddress().getCity(),
                        person.getAddress().getState(),
                        person.getAddress().getCountry()))
                .collect(Collectors.toList());
    }
}
