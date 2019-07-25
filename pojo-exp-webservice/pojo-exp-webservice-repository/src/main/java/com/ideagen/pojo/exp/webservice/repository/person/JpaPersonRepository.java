package com.ideagen.pojo.exp.webservice.repository.person;

import com.ideagen.pojo.exp.webservice.entity.person.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPersonRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByName(String name);
}
