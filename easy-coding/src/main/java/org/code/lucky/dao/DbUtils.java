package org.code.lucky.dao;

import org.code.lucky.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbUtils extends JpaRepository<Person, Integer>
{

}
