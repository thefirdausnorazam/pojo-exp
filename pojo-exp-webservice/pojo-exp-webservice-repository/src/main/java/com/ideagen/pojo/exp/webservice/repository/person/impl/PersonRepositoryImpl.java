package com.ideagen.pojo.exp.webservice.repository.person.impl;

import com.ideagen.pojo.exp.entity.person.Address;
import com.ideagen.pojo.exp.entity.person.Person;
import com.ideagen.pojo.exp.repository.person.PersonRepository;
import com.ideagen.pojo.exp.webservice.repository.person.JpaAddressRepository;
import com.ideagen.pojo.exp.webservice.repository.person.JpaPersonRepository;
import com.ideagen.pojo.exp.webservice.entity.person.AddressEntity;
import com.ideagen.pojo.exp.webservice.entity.person.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Component("personRepository")
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private JpaPersonRepository jpaPersonRepository;

    @Autowired
    private JpaAddressRepository jpaAddressRepository;

    public Person findById(long id) {
        return entityToPojo(jpaPersonRepository.findById(id)
                .orElse(null));
    }

    public Person findByName(String name) {
        return entityToPojo(jpaPersonRepository.findByName(name)
                .orElse(null));
    }

    public Person save(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(person.getName());
        personEntity.setFullName(person.getFullName());
        personEntity.setAge(person.getAge());

        PersonEntity savedPersonEntity = jpaPersonRepository.save(personEntity);

        if (person.getAddress() != null) {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setPersonId(savedPersonEntity.getId());
            addressEntity.setAddressLine1(person.getAddress().getAddressLine1());
            addressEntity.setAddressLine2(person.getAddress().getAddressLine2());
            addressEntity.setPostCode(person.getAddress().getPostCode());
            addressEntity.setCity(person.getAddress().getCity());
            addressEntity.setState(person.getAddress().getState());
            addressEntity.setCountry(person.getAddress().getCountry());

            jpaAddressRepository.save(addressEntity);
        }

        person.setId(personEntity.getId());
        return person;
    }

    public List<Person> getAll() {
        return jpaPersonRepository.findAll()
                .stream()
                .map(personEntity -> entityToPojo(personEntity))
                .collect(Collectors.toList());
    }

    protected Person entityToPojo(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        } else {
            AddressEntity addressEntity = jpaAddressRepository.findByPersonId(personEntity.getId())
                    .orElse(null);

            Address address;

            if (addressEntity != null) {
                address = new Address(addressEntity.getAddressLine1(),
                        addressEntity.getAddressLine2(),
                        addressEntity.getPostCode(),
                        addressEntity.getCity(),
                        addressEntity.getState(),
                        addressEntity.getCountry());
            } else {
                address = null;
            }

            return new Person(personEntity.getId(),
                    personEntity.getName(),
                    personEntity.getFullName(),
                    personEntity.getAge(),
                    address);
        }
    }
}
