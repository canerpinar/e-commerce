package org.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.web.entity.Person;


import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Person,Long> {

}
