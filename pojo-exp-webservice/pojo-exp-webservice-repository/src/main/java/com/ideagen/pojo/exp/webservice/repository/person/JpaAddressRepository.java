package com.ideagen.pojo.exp.webservice.repository.person;

import com.ideagen.pojo.exp.webservice.entity.person.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAddressRepository extends JpaRepository<AddressEntity, Long> {

    Optional<AddressEntity> findByPersonId(long personId);
}
