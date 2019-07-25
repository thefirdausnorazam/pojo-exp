package com.ideagen.pojo.exp.webservice.springweb.configuration.service.person;

import com.ideagen.pojo.exp.repository.person.PersonRepository;
import com.ideagen.pojo.exp.service.person.PersonService;
import com.ideagen.pojo.exp.service.person.PersonServiceFactory;
import com.ideagen.pojo.exp.service.person.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonServiceConfiguration {

    @Autowired
    @Qualifier("personRepository")
    private PersonRepository personRepository;

    @Bean("personService")
    public PersonService personService(){
        return PersonServiceFactory.getService(personRepository);
    }
}
